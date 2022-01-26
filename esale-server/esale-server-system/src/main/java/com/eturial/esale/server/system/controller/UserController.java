package com.eturial.esale.server.system.controller;

import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.eturial.esale.common.entity.QueryRequest;
import com.eturial.esale.common.entity.Response;
import com.eturial.esale.common.entity.system.SystemUser;
import com.eturial.esale.common.exception.EsaleException;
import com.eturial.esale.common.utils.EsaleUtil;
import com.eturial.esale.server.system.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.Map;

@Slf4j
@Validated
@RestController
@RequestMapping(value = "/user1")
@CrossOrigin
public class UserController {
    @Autowired
    private IUserService userService;

    @GetMapping("/view")
    @PreAuthorize("hasAnyAuthority('user:view')")
    public SystemUser user(@RequestParam("username") String username) {
//        Map<String, Object> dataTable = EsaleUtil.getDataTable(userService.findUserDetail(user));
        return userService.findUser(username);
//        return new Response().data(dataTable);
    }

    @GetMapping("/viewAll")
    @PreAuthorize("hasAnyAuthority('user:view')")
    public List<SystemUser> userList() {
//        Map<String, Object> dataTable = EsaleUtil.getDataTable(userService.findUserDetail(user));
        return userService.findUserDetail();
//        return new Response().data(dataTable);
    }

    @PostMapping("/add")
    @PreAuthorize("hasAnyAuthority('user:add')")
    public void addUser(SystemUser user) throws EsaleException {
        try {
            userService.createUser(user);
        } catch (Exception e) {
            String message = "新增用户失败";
            log.error(message, e);
            throw new EsaleException(message);
        }
    }

    @PostMapping("/update")
    @PreAuthorize("hasAnyAuthority('user:update')")
    public void updateUser(SystemUser user) throws EsaleException {
        try {
            userService.updateUser(user);
        } catch (Exception e) {
            String message = "修改用户失败";
            log.error(message, e);
            throw new EsaleException(message);
        }
    }

    @PostMapping("/del")
    @PreAuthorize("hasAnyAuthority('user:delete')")
    public void deleteUsers(@RequestParam("username") String username) throws EsaleException {
        try {
            userService.deleteUsers(username);
        } catch (Exception e) {
            String message = "删除用户失败";
            log.error(message, e);
            throw new EsaleException(message);
        }
    }
}
