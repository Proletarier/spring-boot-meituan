package com.meituan.waimai.business.server.impl;

import com.google.gson.JsonObject;
import com.meituan.waimai.amap.api.IPLocationService;
import com.meituan.waimai.amap.api.PoiSearchService;
import com.meituan.waimai.amap.bean.LocationQuery;
import com.meituan.waimai.amap.bean.PoiSearchQuery;
import com.meituan.waimai.amap.error.AMapErrorException;
import com.meituan.waimai.business.server.MapService;
import com.meituan.waimai.common.RequestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class MapServiceImpl implements MapService {

	@Autowired
	PoiSearchService poiSearchService;

	@Autowired
	IPLocationService ipLocationService;

	@Autowired
	HttpServletRequest request;

	@Override
	public JsonObject location(LocationQuery param) {
		JsonObject jsonObject = null;
		param.setIp(RequestUtil.getRequestIp(request));
		try {
			jsonObject = ipLocationService.location(param);
		} catch (AMapErrorException e) {
			e.printStackTrace();
		}
		return jsonObject;
	}

	@Override
	public JsonObject keywordSearch(PoiSearchQuery param) {
		JsonObject jsonObject = null;
		try {
			jsonObject = poiSearchService.keywordSearch(param);
		} catch (AMapErrorException e) {
			e.printStackTrace();
		}
		return jsonObject;
	}

	@Override
	public JsonObject aroundSearch(PoiSearchQuery param) {
		JsonObject jsonObject = null;
		try {
			jsonObject = poiSearchService.aroundSearch(param);
		} catch (AMapErrorException e) {
			e.printStackTrace();
		}
		return jsonObject;
	}

}
