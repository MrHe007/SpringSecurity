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
package com.bigguy.spring.security.demo.dto.map;/**
 * @Author: hechen
 * @Date: 2019/8/31 13:43
 * @Description: ...
 */

import java.util.HashMap;

/**
 * @author hechen
 * @data 2019/8/31
 */
public class ResponseDto<T> extends HashMap<String, Object> {

    /**
     *
     */
    public static final long serialVersionUID = 8729355094918121406L;

    public static final int RESULT_SUCCESS = 0;

    public static final int RESULT_FAIL = 1;
    /**
     * 0 成功 失败
     */
    private int code;
    /**
     * 错误码
     */
    private String errorCode;
    /**
     * 错误描述
     */
    private String errorDesc;
    /**
     * 存储数据
     */
    private T data;

    public ResponseDto() {
        code = RESULT_SUCCESS;
    }

    public ResponseDto(T data) {
        code = RESULT_SUCCESS;
        if (data != null) {
            this.data = data;
        }
    }

    public ResponseDto(int code) {
        this.code = code;

    }

    public static ResponseDto<?> resultSuccess() {
        ResponseDto<?> result = new ResponseDto<>(RESULT_SUCCESS);
        return result;
    }

    public static ResponseDto<Object> forResultFail() {
        ResponseDto<Object> result = new ResponseDto<>(RESULT_FAIL);
        return result;
    }

    public static ResponseDto<Object> resultSuccessData(Object data) {
        ResponseDto<Object> result = new ResponseDto<>(RESULT_SUCCESS);
        result.setData(data);
        return result;
    }

    public static ResponseDto<?> resultFail(String errorCode, String errorDesc) {
        ResponseDto<Object> result = new ResponseDto<>(RESULT_FAIL);
        result.setErrorCode(errorCode);
        result.setErrorDesc(errorDesc);
        return result;
    }

    public static ResponseDto<?> resultFail(String errorDesc) {
        ResponseDto<Object> result = new ResponseDto<>(RESULT_FAIL);
        result.setErrorDesc(errorDesc);
        return result;
    }

    public static ResponseDto<Object> resultFailData(String errorCode, String errorDesc, Object data) {
        ResponseDto<Object> result = new ResponseDto<>(RESULT_FAIL);
        result.setErrorCode(errorCode);
        result.setErrorDesc(errorDesc);
        result.setData(data);
        return result;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public ResponseDto<T> setResultCodeFaile() {
        this.code = RESULT_FAIL;
        return this;
    }

    public ResponseDto<T> setResultCodeSuccess() {
        this.code = RESULT_SUCCESS;
        return this;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorDesc() {
        return errorDesc;
    }

    public void setErrorDesc(String errorDesc) {
        this.errorDesc = errorDesc;
    }

    public T getData() {
        return data;
    }

    public ResponseDto<T> setData(T data) {
        this.data = data;
        return this;
    }

    public boolean isSuccess() {
        if (RESULT_SUCCESS == (this.code)) {
            return true;
        } else {
            return false;
        }
    }

    public <K> K getData(Class<K> types) {
        return (K) data;
    }

//    public static <T> ResponseDto<T> parseResponse(String response) {
//        return JsonUtils.toObject(response, ResponseDto.class);
//    }
}
