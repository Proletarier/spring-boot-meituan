package com.meituan.waimai.common.model.map;

import lombok.Data;

/**
 * ip定位请求入参
 */
@Data
public class Location {

	/**
	 * IP类型
	 */
	private String type;
	/**
	 * 要查询的ip地址
	 */
	private String ip;
	/**
	 * 数字签名
	 */
	private String sig;
}
