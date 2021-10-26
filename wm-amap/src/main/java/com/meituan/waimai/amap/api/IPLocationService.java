package com.meituan.waimai.amap.api;

import com.alibaba.fastjson.JSONObject;
import com.meituan.waimai.amap.bean.LocationRequest;

public interface IPLocationService {

	/**
	 * 定位2.0
	 * @param param
	 * @return
	 */
	JSONObject location(LocationRequest param);
}
