package com.eturial.esale.common.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.eturial.esale.common.entity.EsaleConstant;
import com.eturial.esale.common.entity.Response;
import org.apache.commons.lang.StringUtils;
import org.springframework.http.MediaType;
import org.springframework.util.Base64Utils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ServerProtectInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse httpServletResponse, Object handler) throws IOException {
        // 从请求头中获取 Zuul Token
        String token = request.getHeader(EsaleConstant.ZUUL_TOKEN_HEADER);
        String zuulToken = new String(Base64Utils.encode(EsaleConstant.ZUUL_TOKEN_VALUE.getBytes()));
        // 校验 Zuul Token的正确性
        if (StringUtils.equals(zuulToken, token)) {
            return true;
        } else {
            Response response = new Response();
            httpServletResponse.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
            httpServletResponse.setStatus(HttpServletResponse.SC_FORBIDDEN);
            httpServletResponse.getWriter().write(JSONObject.toJSONString(response.message("请通过网关获取资源")));
            return false;
        }
    }
}
