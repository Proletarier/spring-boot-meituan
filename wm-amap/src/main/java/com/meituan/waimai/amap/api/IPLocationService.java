package com.meituan.waimai.amap.api;

import com.google.gson.JsonObject;
import com.meituan.waimai.amap.bean.LocationQuery;
import com.meituan.waimai.amap.error.AMapErrorException;

public interface IPLocationService {

	/**
	 * 定位2.0
	 * @param param
	 * @return
	 */
	JsonObject location(LocationQuery param) throws AMapErrorException;

}
