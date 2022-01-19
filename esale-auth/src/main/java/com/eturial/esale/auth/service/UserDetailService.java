package com.eturial.esale.auth.service;

import com.eturial.esale.auth.manager.UserManager;
import com.eturial.esale.common.entity.AuthUser;
import com.eturial.esale.common.entity.system.SystemUser;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserDetailService implements UserDetailsService {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserManager userManager;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        System.out.println("asjfhgusahdugf  " + username);
        SystemUser systemUser = userManager.findByName(username);
        if (systemUser != null) {
            String permissions = userManager.findUserPermissions(systemUser.getUsername());
            boolean notLocked = false;
            if (StringUtils.equals(SystemUser.STATUS_VALID, systemUser.getStatus()))
                notLocked = true;
            AuthUser authUser = null;
            if(Objects.equals(systemUser.getRoleId(), "1")) {
                authUser = new AuthUser(systemUser.getUsername(), systemUser.getPassword(), true, true, true, notLocked,
                        AuthorityUtils.commaSeparatedStringToAuthorityList("user:add,user:update,user:delete,user:view"));
            }
            else {
                authUser = new AuthUser(systemUser.getUsername(), systemUser.getPassword(), true, true, true, notLocked,
                        AuthorityUtils.commaSeparatedStringToAuthorityList("user:update"));
            }

            BeanUtils.copyProperties(systemUser,authUser);
            return authUser;
        } else {
            throw new UsernameNotFoundException("");
        }
    }
}
