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
package com.bigguy.spring.security.demo.config;/**
 * @Author: hechen
 * @Date: 2019/8/31 11:02
 * @Description: ...
 */

import com.bigguy.spring.security.demo.cst.ParamConstants;
import com.bigguy.spring.security.demo.security.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author hechen
 * @data 2019/8/31
 */

@Configuration
@EnableWebSecurity
public class SecurityConfiguration  extends WebSecurityConfigurerAdapter{

    /**
     * 校验用户登入
     */
    @Autowired
    CustomUserDetailsServiceImpl customUserDetailsService;

    @Autowired
    MyAuthenticationProvider authenticationProvider;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeRequests()
               .antMatchers("/healthCheck", "/accessDenied.json", "/login.json").permitAll()
               .antMatchers("/user/**").hasRole("user")
               .antMatchers("/admin/**").hasRole("admin")
               .anyRequest().authenticated()
               .and()
               .formLogin().loginProcessingUrl("/login.json")
               // 设置登入的请求参数
               .usernameParameter(ParamConstants.LOGIN_NAME)
               .passwordParameter(ParamConstants.LOG_PASSWORD)
               .successHandler(loginSuccessHandler())
               .failureHandler(loginFailHandler())
               .and().logout().logoutUrl("/logout.json");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(customUserDetailsService);

        // 自定义登入验证逻辑
        auth.authenticationProvider(authenticationProvider);
        // 在内存中验证登入的用户，不经过数据库
        auth.inMemoryAuthentication()
                .withUser("admin").password("admin").roles("admin", "user")
                .and()
                .withUser("hechen").password("hechen").roles("user");
    }


//    @Bean
//    public BCryptPasswordEncoder passwordEncoder() { //密码加密
//        return new BCryptPasswordEncoder(4);
//    }


    @Bean
    public LoginSuccessHandler loginSuccessHandler() {
        return new LoginSuccessHandler();
    }

    @Bean
    public LoginFailHandler loginFailHandler() {
        return new LoginFailHandler();
    }

    @Bean
    public MyLogoutSuccessHandler logoutSuccessHandler() {
        return new MyLogoutSuccessHandler();
    }
}
