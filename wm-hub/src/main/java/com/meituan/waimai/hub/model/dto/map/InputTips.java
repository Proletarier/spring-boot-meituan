package com.meituan.waimai.hub.model.dto.map;

import lombok.Data;

/**
 * 输入提示查询入参
 */
@Data
public class InputTips {

	/**
	 * 关键字
	 */
	private String keywords;
	/**
	 * POI分类
	 */
	private String type;
	/**
	 * 坐标
	 */
	private String location;
	/**
	 * 搜索城市
	 */
	private String city;
	/**
	 * 仅返回指定城市数据
	 */
	private String citylimit;
	/**
	 * 返回的数据类型
	 */
	private String datatype;
	/**
	 * 数字签名
	 */
	private String sig;
}
