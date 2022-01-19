package com.eturial.esale.auth;

import com.eturial.esale.common.annotation.EnableEsaleAuthExceptionHandler;
import com.eturial.esale.common.annotation.EnableEsaleLettuceRedis;
import com.eturial.esale.common.annotation.EnableEsaleServerProtect;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableEsaleLettuceRedis
@EnableEsaleServerProtect
@EnableDiscoveryClient
@SpringBootApplication
@EnableEsaleAuthExceptionHandler
@MapperScan("com.eturial.esale.auth.mapper")
public class EsaleAuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(EsaleAuthApplication.class, args);
    }

}
