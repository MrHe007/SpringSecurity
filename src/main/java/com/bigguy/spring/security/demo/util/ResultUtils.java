package com.bigguy.spring.security.demo.util;

import com.bigguy.spring.security.demo.cst.ParamConstants;
import com.bigguy.spring.security.demo.cst.ResultCodeConstants;
import com.bigguy.spring.security.demo.error.ErrorCodeEnum;

import java.util.HashMap;
import java.util.Map;

public class ResultUtils {
	
	public static Map<String, Object> buildSuccessResult(){
		Map<String, Object> map = new HashMap<>();
		map.put(ParamConstants.RESULT_CODE, ResultCodeConstants.SUCCESS);
		map.put(ParamConstants.ERROR_CODE, ErrorCodeEnum.SUCCESS.getErrorCode());
		map.put(ParamConstants.ERROR_DESC, ErrorCodeEnum.SUCCESS.getErrorDesc());
		
		return map;
	}
	
	public static Map<String, Object> buildFailResult(ErrorCodeEnum errorEnum){
		Map<String, Object> map = new HashMap<>();
		map.put(ParamConstants.RESULT_CODE, ResultCodeConstants.FAIL);
		map.put(ParamConstants.ERROR_CODE, errorEnum.getErrorCode());
		map.put(ParamConstants.ERROR_DESC, errorEnum.getErrorDesc());
		
		return map;
	}

	public static Map<String, Object> buildFailResult(String errorEesc){
		Map<String, Object> map = new HashMap<>();
		map.put(ParamConstants.RESULT_CODE, ResultCodeConstants.FAIL);
		map.put(ParamConstants.ERROR_CODE, -1);
		map.put(ParamConstants.ERROR_DESC, errorEesc);

		return map;
	}
}

	