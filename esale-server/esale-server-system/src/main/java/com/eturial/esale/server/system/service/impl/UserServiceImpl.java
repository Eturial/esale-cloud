package com.eturial.esale.server.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.eturial.esale.common.entity.QueryRequest;
import com.eturial.esale.common.entity.system.SystemUser;
import com.eturial.esale.common.entity.system.UserRole;
import com.eturial.esale.server.system.mapper.UserMapper;
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

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class UserServiceImpl implements IUserService{
    @Autowired
    private IUserRoleService userRoleService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserMapper userMapper;

    @Override
    public IPage<SystemUser> findUserDetail(SystemUser user, QueryRequest request) {
        return null;
    }

    public List<SystemUser> findUserDetail(String username) {
//        Page<SystemUser> page = new Page<>(request.getPageNum(), request.getPageSize());
        return userMapper.findUserDetail(username);
    }

    @Override
    public void createUser(SystemUser user) {

    }

    @Override
    public void updateUser(SystemUser user) {

    }

    @Override
    public void deleteUsers(String[] userIds) {

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

//    private void setUserRoles(SystemUser user, String[] roles) {
//        Arrays.stream(roles).forEach(roleId -> {
//            UserRole ur = new UserRole();
//            ur.setUserId(user.getUserId());
//            ur.setRoleId(Long.valueOf(roleId));
//            userRoleService.save(ur);
//        });
//    }
}
