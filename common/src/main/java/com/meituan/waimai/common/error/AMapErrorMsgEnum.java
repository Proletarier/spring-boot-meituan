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
	MAP_10011("10011","服务不支持https请求"),
	MAP_10012("10012","权限不足，服务请求被拒绝"),
	MAP_10013("10013","Key被删除"),
	MAP_10014("10014","云图服务QPS超限"),
	MAP_10015("10015","受单机QPS限流限制"),
	MAP_10016("10016","服务器负载过高"),
	MAP_10017("10017","所请求的资源不可用"),
	MAP_10019("10019","使用的某个服务总QPS超限"),
	MAP_10020("10020","某个Key使用某个服务接口QPS超出限制"),
	MAP_10021("10021","账号使用某个服务接口QPS超出限制"),
	MAP_10026("10026","账号处于被封禁状态"),
	MAP_20000("20000","请求参数非法"),
	MAP_20001("20001","缺少必填参数"),
	MAP_20002("20002","请求协议非法"),
	MAP_20003("20003","其他未知错误"),
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
