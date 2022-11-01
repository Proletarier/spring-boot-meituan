package com.meituan.waimai.hub.model.dto.map;

import lombok.Data;

/**
 * ip定位请求出参
 */
@Data
public class LocationResponse {

	/**
	 * 状态码
	 */
	private String status;
	/**
	 * 返回状态说明
	 */
	private String info;
	/**
	 * 状态码
	 */
	private String infoCode;
	/**
	 * 国家
	 */
	private String country;
	/**
	 *  省份
	 */
	private String province;
	/**
	 *  城市
	 */
	private String city;
	/**
	 * 区县
	 */
	private String district;
	/**
	 * 运营商
	 */
	private String isp;
	/**
	 * 经纬度
	 */
	private String location;
	/**
	 * Ip
	 */
	private String ip;

}
