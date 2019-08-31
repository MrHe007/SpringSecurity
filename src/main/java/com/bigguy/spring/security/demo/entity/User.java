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
package com.bigguy.spring.security.demo.entity;/**
 * @Author: hechen
 * @Date: 2019/8/31 14:27
 * @Description: ...
 */

import lombok.Data;

/**
 * @author hechen
 * @data 2019/8/31
 */
@Data
public class User {
    private Integer id;
    private String username;
    private String password;
    private String email;
    private String telephone;
    private String role;
    private String image;
    private String lastIp;
    private String lastTime;
}
