package com.eturial.esale.auth.configure;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.*;
import java.io.IOException;
import java.util.Map;
import java.util.logging.LogRecord;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class ECorsFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;

        Map map = httpServletRequest.getParameterMap();
        System.out.println(httpServletRequest.getHeader("Authorization"));
        for (Object key: map.keySet()) {
            System.out.println(key + " " + "uadihfuashfguiafhg   " + map.get(key));
        }
//        System.out.println(httpServletRequest.getParameterMap().toString());

        filterChain.doFilter(servletRequest, servletResponse);
    }
}
