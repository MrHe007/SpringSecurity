/*
Copyright (C) 2011-$today.year. ShenZhen IBOXCHAIN Information Technology Co.,Ltd.

All right reserved.

This software is the confidential and proprietary
information of IBOXCHAIN Company of China.
("Confidential Information"). You shall not disclose
such Confidential Information and shall use it only
in accordance with the terms of the contract agreement
you entered into with IBOXCHAIN inc.

*/
package com.bigguy.spring.security.demo.dao;

import com.bigguy.spring.security.demo.dto.UserPermissionDto;
import com.bigguy.spring.security.demo.dto.UserRoleDto;
import com.bigguy.spring.security.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Auther: hechen
 * @Date: 2019/7/29 11:20
 * @Description: ...
 */
@Mapper
public interface UserMapper {

    @Select("select t.* from user t")
    List<User> findUserList();

    User findUser(Integer id);

    /**
     * 通过名字查找用户
     * @param username
     * @return
     */
    @Select("SELECT u.* FROM USER u WHERE u.`username` = #{username}")
    User findUserByName(String username);

    /**
     * 查找用户关联角色
     * @param username
     * @return
     */
    List<UserRoleDto> findUserRelRole(String username);

    /**
     * 查找用户关联权限
     * @param username
     * @return
     */
    List<UserPermissionDto> findUerRelPermission(String username);

}
