package com.eturial.esale.auth.manager;

import com.eturial.esale.auth.mapper.UserMapper;
import com.eturial.esale.common.entity.system.SystemUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserManager {
    @Autowired
    private UserMapper userMapper;

    public SystemUser findByName(String username) {
//        System.out.println(userMapper.findByName(username));
        return userMapper.findByName(username);
    }

    public String findUserPermissions(String username) {
        return null;
    }
}
