package com.eturial.esale.server.system;

import com.eturial.esale.common.annotation.EnableEsaleAuthExceptionHandler;
import com.eturial.esale.common.annotation.EnableEsaleServerProtect;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableEsaleServerProtect
@EnableDiscoveryClient   // 开启服务注册与发现
@SpringBootApplication
@EnableTransactionManagement
@EnableGlobalMethodSecurity(prePostEnabled = true)    // 开启Spring Cloud Security权限注解
@EnableEsaleAuthExceptionHandler
@MapperScan("com.eturial.esale.server.system.mapper")
public class EsaleServerSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(EsaleServerSystemApplication.class, args);
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
