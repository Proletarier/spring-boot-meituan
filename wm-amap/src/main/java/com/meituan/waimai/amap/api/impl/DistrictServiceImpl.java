package com.meituan.waimai.amap.api.impl;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.meituan.waimai.amap.api.AMapService;
import com.meituan.waimai.amap.api.DistrictService;
import com.meituan.waimai.amap.bean.DistrictQuery;
import com.meituan.waimai.amap.error.AMapError;
import com.meituan.waimai.amap.error.AMapErrorException;
import com.meituan.waimai.common.util.json.GsonHelper;
import org.springframework.beans.factory.annotation.Autowired;

import static com.meituan.waimai.amap.enums.AMapUrl.District.DISTRICT_SEARCH;

public class DistrictServiceImpl implements DistrictService {

	@Autowired
	private AMapService aMapService;

	@Override
	public JsonObject districtSearch(DistrictQuery param) throws AMapErrorException {
		String json = aMapService.get(DISTRICT_SEARCH.getUrl(), GsonHelper.ObjectToMapString(param));
		JsonObject jsonObject = JsonParser.parseString(json).getAsJsonObject();
		if (!"1".equals(jsonObject.get("status").getAsString())) {
			throw new AMapErrorException(AMapError.fromJson(json));
		}
		return jsonObject;
	}
}
