package com.meituan.waimai.common.model.map;

import lombok.Data;

/**
 * 关键字搜索、 周边搜索请求入参
 */
@Data
public class PoiSearch {

	/**
	 * IP类型
	 */
	private String location;
	/**
	 * 查询关键字
	 */
	private String keywords;
	/**
	 * 查询POI类型
	 */
	private String types;
	/**
	 * 查询城市
	 */
	private String city;
	/**
	 * 查询半径
	 */
	private String radius;
	/**
	 * 排序规则
	 */
	private String sortrule;
	/**
	 * 每页记录数据
	 */
	private String offset;
	/**
	 * 当前页数
	 */
	private String page;
	/**
	 * 返回结果控制
	 */
	private String extensions;
	/**
	 * 数字签名
	 */
	private String sig;
	/**
	 * 返回数据格式类型
	 */
	private String output;
	/**
	 * 回调函数
	 */
	private String callback;
}
