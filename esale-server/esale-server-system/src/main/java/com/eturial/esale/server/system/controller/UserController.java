package com.eturial.esale.server.system.controller;

import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.eturial.esale.common.entity.QueryRequest;
import com.eturial.esale.common.entity.Response;
import com.eturial.esale.common.entity.system.SystemUser;
import com.eturial.esale.common.exception.EsaleException;
import com.eturial.esale.common.utils.EsaleUtil;
import com.eturial.esale.server.system.service.IUserService;
import lombok.extern.slf4j.Slf4j;
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
@RequestMapping("user1")

public class UserController {
    @Autowired
    private IUserService userService;

    @GetMapping("/view")
    @PreAuthorize("hasAnyAuthority('user:view')")
    public List<SystemUser> userList(@RequestParam("username") String username) {
//        Map<String, Object> dataTable = EsaleUtil.getDataTable(userService.findUserDetail(user));
        return userService.findUserDetail(username);
//        return new Response().data(dataTable);
    }

    @PostMapping
    @PreAuthorize("hasAnyAuthority('user:add')")
    public void addUser(@Valid SystemUser user) throws EsaleException {
        try {
            this.userService.createUser(user);
        } catch (Exception e) {
            String message = "新增用户失败";
            log.error(message, e);
            throw new EsaleException(message);
        }
    }

    @PutMapping
    @PreAuthorize("hasAnyAuthority('user:update')")
    public void updateUser(@Valid SystemUser user) throws EsaleException {
        try {
            this.userService.updateUser(user);
        } catch (Exception e) {
            String message = "修改用户失败";
            log.error(message, e);
            throw new EsaleException(message);
        }
    }

    @DeleteMapping("/{userIds}")
    @PreAuthorize("hasAnyAuthority('user:delete')")
    public void deleteUsers(@NotBlank(message = "{required}") @PathVariable String userIds) throws EsaleException {
        try {
            String[] ids = userIds.split(StringPool.COMMA);
            this.userService.deleteUsers(ids);
        } catch (Exception e) {
            String message = "删除用户失败";
            log.error(message, e);
            throw new EsaleException(message);
        }
    }
}
