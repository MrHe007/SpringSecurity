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
 * @Date: 2019/8/31 11:19
 * @Description: ...
 */

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hechen
 * @data 2019/8/31
 */
@RestController
@RequestMapping("/admin")
public class AdminController {

    @GetMapping("/admin")
    public Object adminPage(){
        return "admin page";
    }

}
