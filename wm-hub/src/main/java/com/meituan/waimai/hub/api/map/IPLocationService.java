package com.meituan.waimai.hub.api.map;

import com.google.gson.JsonObject;
import com.meituan.waimai.hub.model.dto.map.Location;
import com.meituan.waimai.common.exception.AMapErrorException;

public interface IPLocationService {

	/**
	 * 定位2.0
	 * @param param
	 * @return
	 */
	JsonObject location(Location param)  throws AMapErrorException;

}
