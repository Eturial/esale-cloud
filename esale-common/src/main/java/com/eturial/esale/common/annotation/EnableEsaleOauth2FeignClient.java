package com.eturial.esale.common.annotation;

import com.eturial.esale.common.configure.EsaleOAuth2FeignConfigure;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(EsaleOAuth2FeignConfigure.class)
public @interface EnableEsaleOauth2FeignClient {

}
