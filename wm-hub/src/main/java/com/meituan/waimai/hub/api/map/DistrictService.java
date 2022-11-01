package com.meituan.waimai.hub.api.map;

import com.google.gson.JsonObject;
import com.meituan.waimai.hub.model.dto.map.District;
import com.meituan.waimai.common.exception.AMapErrorException;

public interface DistrictService {

	/**
	 * 行政区域查询
	 * @param param
	 * @return
	 * @throws AMapErrorException
	 */
	JsonObject districtSearch(District param) throws AMapErrorException;

}
