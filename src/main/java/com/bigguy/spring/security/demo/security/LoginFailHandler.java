package com.bigguy.spring.security.demo.security;

import com.bigguy.spring.security.demo.dto.ResponseDto;
import com.bigguy.spring.security.demo.error.ErrorCodeEnum;
import com.bigguy.spring.security.demo.util.PrintUtils;
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
			PrintUtils.outPrint(response, ResponseDto.resultFail(ErrorCodeEnum.USER_NOT_FOUND.getErrorDesc()));
		}
		
		if(exception instanceof BadCredentialsException){
			PrintUtils.outPrint(response, ResponseDto.resultFail(ErrorCodeEnum.PASSWORD_INVAILD.getErrorDesc()));
		}
		
		if(exception instanceof DisabledException){
			PrintUtils.outPrint(response, ResponseDto.resultFail(ErrorCodeEnum.USER_IS_DISABLE.getErrorDesc()));
		}
	}

}

	