package com.meituan.waimai.common.error;

import lombok.Getter;

@Getter
public enum AMapErrorMsgEnum {

	MAP_10001("10001","key不正确或过期");

	private String code;
	private String msg;

	AMapErrorMsgEnum(String code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	/**
	 * 通过错误代码查找其中文含义..
	 */
	public static String findMsgByCode(String code) {
		for (AMapErrorMsgEnum value : AMapErrorMsgEnum.values()) {
			if (value.code.equals(code)) {
				return value.msg;
			}
		}
		return null;
	}
}
