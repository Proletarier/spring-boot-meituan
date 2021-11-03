package com.meituan.waimai.amap.bean;

import lombok.Data;

/**
 * 行政区域查询入参
 */
@Data
public class DistrictQuery extends  BaseQuery {


	/**
	 * 查询关键字
	 */
	private String keywords;

	/**
	 * 子级行政区
	 */
	private String subdistrict;

	/**
	 * 需要第几页数据
	 */
	private String page;

	/**
	 * 最外层返回数据个数
	 */
	private String offset;

	/**
	 * 返回结果控制
	 */
	private String extensions;

	/**
	 * 根据区划过滤
	 */
	private String filter;

}
