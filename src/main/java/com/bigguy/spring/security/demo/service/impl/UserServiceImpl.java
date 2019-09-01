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
package com.bigguy.spring.security.demo.service.impl;/**
 * @Auther: hechen
 * @Date: 2019/7/29 13:50
 * @Description: ...
 */

import com.bigguy.spring.security.demo.dao.UserMapper;
import com.bigguy.spring.security.demo.dto.UserPermissionDto;
import com.bigguy.spring.security.demo.dto.UserRoleDto;
import com.bigguy.spring.security.demo.entity.User;
import com.bigguy.spring.security.demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hechen
 * @data 2019/7/29
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public List<User> getUserLis() {
        return userMapper.findUserList();
    }

    @Override
    public User getUser(Integer id) {
        return userMapper.findUser(id);
    }

    @Override
    public User getUserByName(String username) {
        return userMapper.findUserByName(username);
    }

    @Override
    public List<UserRoleDto> getUserRoleList(String username) {
        return userMapper.findUserRelRole(username);
    }

    @Override
    public List<UserPermissionDto> getUserPermList(String username) {
        return userMapper.findUerRelPermission(username);
    }


}
