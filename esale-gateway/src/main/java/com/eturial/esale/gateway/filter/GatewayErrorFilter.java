package com.eturial.esale.gateway.filter;

import com.eturial.esale.common.entity.Response;
import com.eturial.esale.common.utils.EsaleUtil;
import com.netflix.zuul.context.RequestContext;
import io.lettuce.core.dynamic.support.ReflectionUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.cloud.netflix.zuul.filters.post.SendErrorFilter;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;

@Slf4j
@Component
public class GatewayErrorFilter extends SendErrorFilter {
    @Override
    public Object run() {
        try {
            Response response = new Response();
            RequestContext ctx = RequestContext.getCurrentContext();
            String serviceId = (String) ctx.get(FilterConstants.SERVICE_ID_KEY);

            ExceptionHolder exception = findZuulException(ctx.getThrowable());
            String errorCause = exception.getErrorCause();
            Throwable throwable = exception.getThrowable();
            String message = throwable.getMessage();
            message = StringUtils.isBlank(message) ? errorCause : message;
            response = resolveExceptionMessage(message, serviceId, response);

            HttpServletResponse httpServletResponse = ctx.getResponse();
            EsaleUtil.makeResponse(
                    httpServletResponse, MediaType.APPLICATION_JSON_UTF8_VALUE,
                    HttpServletResponse.SC_INTERNAL_SERVER_ERROR, response
            );
            log.error("Zuul sendError：{}", response.getMessage());
        } catch (Exception ex) {
            log.error("Zuul sendError", ex);
            ReflectionUtils.rethrowRuntimeException(ex);
        }
        return null;
    }

    private Response resolveExceptionMessage(String message, String serviceId, Response response) {
        if (StringUtils.containsIgnoreCase(message, "time out")) {
            return response.message("请求" + serviceId + "服务超时");
        }
        if (StringUtils.containsIgnoreCase(message, "forwarding error")) {
            return response.message(serviceId + "服务不可用");
        }
        return response.message("Zuul请求" + serviceId + "服务异常");
    }
}
