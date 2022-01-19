package com.eturial.esale.auth.controller;

import com.eturial.esale.auth.service.UserDetailService;
import com.eturial.esale.auth.service.ValidateCodeService;
import com.eturial.esale.common.entity.Response;
import com.eturial.esale.common.exception.AuthException;
import com.eturial.esale.common.exception.ValidateCodeException;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.provider.token.ConsumerTokenServices;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.Principal;

@RestController
@Controller
public class SecurityController {

    @Autowired
    private UserDetailService userDetailService;

    @Autowired
    private ConsumerTokenServices consumerTokenServices;

    @Autowired
    private ValidateCodeService validateCodeService;

    @GetMapping("oauth/test")
    public String testOauth() {
        return "oauth";
    }

    @GetMapping("/user")
//    public UserDetails currentUser(@RequestParam("username") String username) {
    public UserDetails currentUser() {
//            System.out.println("2qhfefug ");
//        return userDetailService.loadUserByUsername(username);
        return userDetailService.loadUserByUsername("eturial");
    }

    @GetMapping("captcha")
    public void captcha(HttpServletRequest request, HttpServletResponse response) throws IOException, ValidateCodeException {
        validateCodeService.create(request, response);
    }

    @DeleteMapping("signout")
    public Response signout(HttpServletRequest request) throws AuthException {
        String authorization = request.getHeader("Authorization");
        String token = StringUtils.replace(authorization, "bearer ", "");
        Response response = new Response();
        if (!consumerTokenServices.revokeToken(token)) {
            throw new AuthException("退出登录失败");
        }
        return response.message("退出登录成功");
    }
}
