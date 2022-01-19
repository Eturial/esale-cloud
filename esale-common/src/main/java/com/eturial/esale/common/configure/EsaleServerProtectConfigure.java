package com.eturial.esale.common.configure;

import com.eturial.esale.common.interceptor.ServerProtectInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class EsaleServerProtectConfigure implements WebMvcConfigurer {
    @Bean
    public HandlerInterceptor esaleServerProtectInterceptor() {
        return new ServerProtectInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(esaleServerProtectInterceptor());
    }
}
