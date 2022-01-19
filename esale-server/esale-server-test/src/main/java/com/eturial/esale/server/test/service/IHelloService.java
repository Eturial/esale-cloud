package com.eturial.esale.server.test.service;

import com.eturial.esale.common.entity.ServerConstant;
import com.eturial.esale.server.test.service.fallback.HelloServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

// 表明这是一个Feign Client
@FeignClient(value = ServerConstant.SERVER_SYSTEM, contextId = "helloServiceClient", fallbackFactory = HelloServiceFallback.class)
public interface IHelloService {

    @GetMapping("hello")
    String hello(@RequestParam("name") String name);
}
