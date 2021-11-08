package com.meituan.waimai.common.error;

import lombok.Getter;

@Getter
public enum AMapErrorMsgEnum {

	MAP_10001("10001","key不正确或过期"),
	MAP_10002("10002","没有权限使用相应的服务或者请求接口的路径拼写错误"),
	MAP_10003("10003","访问已超出日访问量"),
	MAP_10004("10004","单位时间内访问过于频繁"),
	MAP_10005("10005","IP白名单出错，发送请求的服务器IP不在IP白名单内"),
	MAP_10006("10006","绑定域名无效"),
	MAP_10007("10007","数字签名未通过验证"),
	MAP_10008("10008","MD5安全码未通过验证"),
	MAP_10009("10009","请求key与绑定平台不符"),
	MAP_10010("10010","IP访问超限"),
	MAP_99999("99999","网络异常");


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
