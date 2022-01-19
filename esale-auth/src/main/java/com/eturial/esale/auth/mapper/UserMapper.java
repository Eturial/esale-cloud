package com.eturial.esale.auth.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.eturial.esale.common.entity.system.SystemUser;

public interface UserMapper extends BaseMapper<SystemUser> {
    SystemUser findByName(String username);
}
