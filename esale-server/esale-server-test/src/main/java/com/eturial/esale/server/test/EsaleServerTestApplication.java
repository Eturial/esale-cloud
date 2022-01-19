package com.eturial.esale.server.test;

import com.eturial.esale.common.annotation.EnableEsaleAuthExceptionHandler;
import com.eturial.esale.common.annotation.EnableEsaleOauth2FeignClient;
import com.eturial.esale.common.annotation.EnableEsaleServerProtect;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@EnableEsaleServerProtect
@EnableEsaleOauth2FeignClient
@EnableFeignClients
@EnableDiscoveryClient
@EnableGlobalMethodSecurity(prePostEnabled = true)
@SpringBootApplication
@EnableEsaleAuthExceptionHandler
public class EsaleServerTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(EsaleServerTestApplication.class, args);
    }

}
