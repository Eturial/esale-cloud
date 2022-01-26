package com.eturial.esale.server.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.eturial.esale.common.entity.system.SystemUser;
import com.eturial.esale.server.system.entity.SaleUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {
//    /**
//     * 查找用户详细信息
//     *
//     * @param page 分页对象
//     * @param user 用户对象，用于传递查询条件
//     * @return Ipage
//     */
    //IPage<SystemUser> findUserDetailPage(Page page, @Param("user") SystemUser user);
    List<SystemUser> findUserDetail ();

    void newUser(@Param("user") SystemUser user);
    String selectIdByUsername(@Param("username") String username);

    SystemUser findUser(@Param("username") String username);

    void updateUser(@Param("user") SystemUser user);

    void deleteUser(@Param("username") String username);
}
