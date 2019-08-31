package com.bigguy.spring.security.demo.error;

public enum ErrorCodeEnum {
	/**
	 * SUCCESS成功
	 */
	SUCCESS("1", "成功"),
	NOT_LOGIN("SEC_2", "未登录"),
	USER_NOT_FOUND("SEC_3","用户不存在"),
	PASSWORD_INVAILD("SEC_4","密码错误"),
	USER_IS_DISABLE("SEC_5","用户已禁用"),
	ACCESS_DENIED("SEC_6","权限不足"),
	ROLE_EXIST("SEC_7","角色已存在"),
	USER_EXIST("SEC_8","用户已存在");

	ErrorCodeEnum(String errorCode, String errorDesc) {
		this.errorCode = errorCode;
		this.errorDesc = errorDesc;
	}

	private String errorDesc;

	private String errorCode;

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

	public static String getDescByStatus(String errorCode) {
		ErrorCodeEnum[] enums = ErrorCodeEnum.values();
		for (ErrorCodeEnum recordEnum : enums) {
			if (recordEnum.getErrorCode().equals(errorCode)) {
				return recordEnum.getErrorDesc();
			}
		}
		return null;
	}
}
