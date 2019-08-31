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
 * @Date: 2019/8/31 16:52
 * @Description: ...
 */

import com.bigguy.spring.security.demo.dto.ResponseDto;
import com.bigguy.spring.security.demo.util.PrintUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * @author hechen
 * @data 2019/8/31
 */
@Slf4j
public class LoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws ServletException, IOException {
        SecurityUser user = (SecurityUser)authentication.getPrincipal();
        //输出登录提示信息
        log.info(user.getUsername() +" login success!");

        Map<String, Object> map = ResponseDto.resultSuccess();
        map.put("userName", user.getUsername());
        PrintUtils.outPrint(response, map);
    }
}
