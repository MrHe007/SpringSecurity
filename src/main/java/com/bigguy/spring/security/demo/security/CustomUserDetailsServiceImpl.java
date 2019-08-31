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
package com.bigguy.spring.security.demo.security;/**
 * @Author: hechen
 * @Date: 2019/8/31 15:27
 * @Description: ...
 */

import com.bigguy.spring.security.demo.entity.User;
import com.bigguy.spring.security.demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author hechen
 * @data 2019/8/31
 */
@Service
public class CustomUserDetailsServiceImpl implements UserDetailsService{

    @Autowired
    IUserService userService;

    @Override
    public UserDetails loadUserByUsername(String loginName) throws UsernameNotFoundException {

        User user = userService.getUserByName(loginName);

        if(null == user){
            throw new UsernameNotFoundException("loginName " + loginName + " not found");
        }

        // 为登入用户分配角色
//        List<SysRole> sysRoles = sysRoleMapper.findUserRoles(user.getId());
//        user.setSysRoles(sysRoles);
//        // SecurityUser实现UserDetails并将SysUser的name映射为username
        SecurityUser seu = new SecurityUser(user);
        return  seu;
    }
}
