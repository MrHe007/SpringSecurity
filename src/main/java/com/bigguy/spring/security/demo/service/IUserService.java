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
package com.bigguy.spring.security.demo.service;/**
 * @Auther: hechen
 * @Date: 2019/7/29 13:49
 * @Description: ...
 */

import com.bigguy.spring.security.demo.entity.User;

import java.util.List;

/**
 * @author hechen
 * @data 2019/7/29
 */
public interface IUserService {

    public List<User> getUserLis();

    public User getUser(Integer id);

    User getUserByName(String username);

}
