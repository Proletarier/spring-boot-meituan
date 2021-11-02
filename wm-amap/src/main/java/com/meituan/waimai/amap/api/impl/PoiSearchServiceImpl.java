package com.meituan.waimai.amap.api.impl;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.meituan.waimai.amap.api.AMapService;
import com.meituan.waimai.amap.api.PoiSearchService;
import com.meituan.waimai.amap.bean.PoiSearchQuery;
import com.meituan.waimai.amap.error.AMapError;
import com.meituan.waimai.amap.error.AMapErrorException;
import com.meituan.waimai.common.util.json.GsonHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.meituan.waimai.amap.enums.AMapUrl.Poi.*;

@Service
public class PoiSearchServiceImpl implements PoiSearchService {

	@Autowired
	private AMapService aMapService;

	@Override
	public JsonObject keywordSearch(PoiSearchQuery request) throws AMapErrorException {

		String json = aMapService.get(POI_KEYWORD_SEARCH.getUrl(), GsonHelper.ObjectToMapString(request));
		JsonObject jsonObject = JsonParser.parseString(json).getAsJsonObject();

		if (!"1".equals(jsonObject.get("status").getAsString())) {
			throw new AMapErrorException(AMapError.fromJson(json));
		}
		return jsonObject;
	}

	@Override
	public JsonObject aroundSearch(PoiSearchQuery request) throws AMapErrorException {

		String json = aMapService.get(POI_AROUND_SEARCH.getUrl(), GsonHelper.ObjectToMapString(request));
		JsonObject jsonObject = JsonParser.parseString(json).getAsJsonObject();

		if (!"1".equals(jsonObject.get("status").getAsString())) {
			throw new AMapErrorException(AMapError.fromJson(json));
		}
		return jsonObject;
	}
}
