package com.meituan.waimai.amap.api;

import com.google.gson.JsonObject;
import com.meituan.waimai.amap.bean.District;
import com.meituan.waimai.amap.error.AMapErrorException;

public interface DistrictService {

	/**
	 * 行政区域查询
	 * @param param
	 * @return
	 * @throws AMapErrorException
	 */
	JsonObject districtSearch(District param) throws Exception;

}
