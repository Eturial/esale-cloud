package com.eturial.esale.common.configure;

import com.eturial.esale.common.handler.AuthExceptionEntryPoint;
import com.eturial.esale.common.handler.EsaleAccessDeniedHandler;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;

public class AuthExceptionConfigure {
    @Bean
    @ConditionalOnMissingBean(name = "accessDeniedHandler")
    /*
    当微服务系统的Spring IOC容器中没有名称为accessDeniedHandler的Bean的时候
    就将EsaleAccessDeniedHandler注册为一个Bean
    */
    public EsaleAccessDeniedHandler accessDeniedHandler() {
        return new EsaleAccessDeniedHandler();
    }

    @Bean
    @ConditionalOnMissingBean(name = "authenticationEntryPoint")
    public AuthExceptionEntryPoint authenticationEntryPoint() {
        return new AuthExceptionEntryPoint();
    }
}
