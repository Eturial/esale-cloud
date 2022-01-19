package com.eturial.esale.common.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;
import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = true)
public class AuthUser extends User {
    private static final long serialVersionUID = -6411066541689297219L;

    private String userId;

    private String username;

    private String password;

    private String idNum;

    private String avatar;

    private String userEmail;

    private String userPhone;

    private String userAddress;

    private String realName;

    private String sex;

    private Long roleId;

    private String roleName;

    private Date lastLoginTime;

    private String description;

    private String status;

    public AuthUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
    }

    public AuthUser(String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
    }

}
