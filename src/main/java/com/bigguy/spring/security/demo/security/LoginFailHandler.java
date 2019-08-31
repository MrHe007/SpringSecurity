package com.bigguy.spring.security.demo.security;

import com.bigguy.spring.security.demo.error.ErrorCodeEnum;
import com.bigguy.spring.security.demo.util.PrintUtils;
import com.bigguy.spring.security.demo.util.ResultUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginFailHandler implements AuthenticationFailureHandler {
	
	private static Logger LOG = LoggerFactory.getLogger(LoginFailHandler.class);

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
		if(exception instanceof UsernameNotFoundException){
			LOG.error(exception.getMessage());
			PrintUtils.outPrint(response, ResultUtils.buildFailResult(ErrorCodeEnum.USER_NOT_FOUND));
		}else if(exception instanceof BadCredentialsException){
			PrintUtils.outPrint(response, ResultUtils.buildFailResult(ErrorCodeEnum.PASSWORD_INVAILD));
		}else if(exception instanceof DisabledException){
			PrintUtils.outPrint(response, ResultUtils.buildFailResult(ErrorCodeEnum.USER_IS_DISABLE));
		}else {
			// 未知异常
			PrintUtils.outPrint(response, ResultUtils.buildFailResult("位置异常"));
		}

	}

}

	