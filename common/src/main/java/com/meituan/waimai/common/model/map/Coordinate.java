package com.meituan.waimai.common.model.map;

import lombok.Data;

/**
 * 坐标转换
 */
@Data
public class Coordinate  {

	/**
	 * 坐标点
	 */
	private String locations;

	/**
	 * 原坐标系
	 */
	private String coordsys;

	/**
	 * 数字签名
	 */
	private String sig;
}
