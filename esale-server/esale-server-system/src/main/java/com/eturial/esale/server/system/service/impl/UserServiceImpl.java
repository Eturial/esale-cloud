package com.eturial.esale.server.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.eturial.esale.common.entity.QueryRequest;
import com.eturial.esale.common.entity.system.SystemUser;
import com.eturial.esale.common.entity.system.UserRole;
import com.eturial.esale.common.validator.MobileValidator;
import com.eturial.esale.server.system.mapper.UserMapper;
import com.eturial.esale.server.system.mapper.UserRoleMapper;
import com.eturial.esale.server.system.service.IUserRoleService;
import com.eturial.esale.server.system.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class UserServiceImpl implements IUserService{
    @Autowired
    private IUserRoleService userRoleService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserRoleMapper userRoleMapper;

    @Override
    public IPage<SystemUser> findUserDetail(SystemUser user, QueryRequest request) {
        return null;
    }

    public List<SystemUser> findUserDetail() {
//        Page<SystemUser> page = new Page<>(request.getPageNum(), request.getPageSize());
        return userMapper.findUserDetail();
    }

    @Override
    public SystemUser findUser(String username) {
        return userMapper.findUser(username);
    }

    public void createUser(SystemUser user) {
        if(userMapper.findUser(user.getUsername()) != null) {
            System.out.println("用户名已存在");
            return;
        }
        // 创建用户
        user.setUserId(UUID.randomUUID().toString().replaceAll("-",""));
        user.setCreateTime(new Date());
        user.setAvatar(SystemUser.DEFAULT_AVATAR);
        user.setPassword(passwordEncoder.encode(SystemUser.DEFAULT_PASSWORD));
//        System.out.println(user);
        userMapper.newUser(user);

        // 保存用户角色
        String[] roles = user.getRoleId().split(StringPool.COMMA);
        setUserRoles(user, roles);
    }

    @Override
    public void updateUser(SystemUser user) {
        user.setUpdateTime(new Date());
        if(user.getUsername() == null) {
            System.out.println("用户名不能为空");
            return;
        }
        SystemUser systemUser = userMapper.findUser(user.getUsername());

        if(user.getRealName() != null)
            systemUser.setRealName(user.getRealName());
        if(user.getIdNum() != null)
            systemUser.setIdNum(user.getIdNum());
        if(user.getPassword() != null)
            systemUser.setPassword(user.getPassword());
        if(user.getUserAddress() != null)
            systemUser.setUserAddress(user.getUserAddress());
        if(user.getUserPhone() != null)
            systemUser.setUserPhone(user.getUserPhone());
        if(user.getSex() != null)
            systemUser.setSex(user.getSex());
        if(user.getAvatar() != null)
            systemUser.setAvatar(user.getAvatar());
        if(user.getDescription() != null)
            systemUser.setDescription(user.getDescription());

        userMapper.updateUser(systemUser);
    }

    public void deleteUsers(String username) {
        userMapper.deleteUser(username);
    }

//    @Override
//    public IPage<SystemUser> findUserDetail(SystemUser user, QueryRequest request) {
//        return null;
//    }

//    @Override
//    @Transactional
//    public void createUser(SystemUser user) {
//        // 创建用户
//        user.setCreateTime(new Date());
//        user.setAvatar(SystemUser.DEFAULT_AVATAR);
//        user.setPassword(passwordEncoder.encode(SystemUser.DEFAULT_PASSWORD));
//        save(user);
//        // 保存用户角色
//        String[] roles = user.getRoleId().split(StringPool.COMMA);
//        setUserRoles(user, roles);
//    }
//
//    @Override
//    @Transactional
//    public void updateUser(SystemUser user) {
//        // 更新用户
//        user.setPassword(null);
//        user.setUsername(null);
//        user.setCreateTime(null);
//        user.setUpdateTime(new Date());
//        updateById(user);
//
//        userRoleService.remove(new LambdaQueryWrapper<UserRole>().eq(UserRole::getUserId, user.getUserId()));
//        String[] roles = user.getRoleId().split(StringPool.COMMA);
//        setUserRoles(user, roles);
//    }
//
//    @Override
//    @Transactional
//    public void deleteUsers(String[] userIds) {
//        List<String> list = Arrays.asList(userIds);
//        removeByIds(list);
//        // 删除用户角色
//        this.userRoleService.deleteUserRolesByUserId(userIds);
//    }

    private void setUserRoles(SystemUser user, String[] roles) {
        Arrays.stream(roles).forEach(roleId -> {
            UserRole ur = new UserRole();
            ur.setUserId(user.getUserId());
            ur.setRoleId(Long.valueOf(roleId));
            System.out.println(ur);
            userRoleMapper.newUserRole(ur);
        });
    }
}
