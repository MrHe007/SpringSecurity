package com.bigguy.spring.security.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

/**
 * @author bigguy_hc
 * @create 2019-09-01 10:02
 *  自定义登入验证逻辑，覆盖掉框架默认逻辑
 */
@Component
public class MyAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    CustomUserDetailsServiceImpl userDetailsService;
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        String loginName = authentication.getName();
        String logPwd = (String)authentication.getCredentials();

        //因为我们是自定义Authentication，所以必须手动加密加盐而不需要再配置, solt 变成了 loginName
        logPwd = new Md5PasswordEncoder().encodePassword(logPwd,loginName);

        UserDetails userDetails = userDetailsService.loadUserByUsername(loginName);
        if(logPwd.equals(userDetails.getPassword())){
            throw new DisabledException("logName"+ loginName +" password error!");
        }

        // 验证通过，授权
//        userDetails.getAuthorities()

        // 返回用户的验证、授权信息
        return new UsernamePasswordAuthenticationToken(userDetails, logPwd, userDetails.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return (UsernamePasswordAuthenticationToken.class
                .isAssignableFrom(authentication));
    }
}
