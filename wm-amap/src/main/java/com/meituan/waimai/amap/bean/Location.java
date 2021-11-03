package com.meituan.waimai.amap.bean;

import lombok.*;

/**
 * ip定位请求入参
 */
@Data
public class Location extends BaseKey {

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
