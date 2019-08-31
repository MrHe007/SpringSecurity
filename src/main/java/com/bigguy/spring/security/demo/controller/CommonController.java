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
package com.bigguy.spring.security.demo.controller;/**
 * @Author: hechen
 * @Date: 2019/8/31 14:41
 * @Description: ...
 */

import com.bigguy.spring.security.demo.entity.User;
import com.bigguy.spring.security.demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author hechen
 * @data 2019/8/31
 */
@RestController
public class CommonController {

    @Autowired
    IUserService userService;

    @GetMapping("/healthCheck")
    public Object healthCheck(){
        List<User> userLis = userService.getUserLis();

        return userLis;
    }

}
