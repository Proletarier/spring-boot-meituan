package com.meituan.waimai.consume.server.impl;

import com.google.gson.JsonObject;
import com.meituan.waimai.amap.api.*;
import com.meituan.waimai.amap.bean.*;
import com.meituan.waimai.business.server.MapService;
import com.meituan.waimai.common.exception.AMapErrorException;
import com.meituan.waimai.common.util.RequestUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class MapServiceImpl implements MapService {

	private static final Logger LOGGER = LoggerFactory.getLogger(MapServiceImpl.class);

	@Autowired
	PoiSearchService poiSearchService;
	@Autowired
	IPLocationService ipLocationService;
	@Autowired
	DistrictService districtService;
	@Autowired
	CoordinateService coordinateService;
	@Autowired
	AssistantService assistantService;
	@Autowired
	HttpServletRequest request;

	@Override
	public JsonObject location(Location param) {
		JsonObject jsonObject = null;
		param.setIp(RequestUtil.getRequestIp(request));
		try {
			jsonObject = ipLocationService.location(param);
		} catch (AMapErrorException e) {
			LOGGER.error(e.getError().toString());
		}
		return jsonObject;
	}

	@Override
	public JsonObject keywordSearch(PoiSearch param) {
		JsonObject jsonObject = null;
		try {
			jsonObject = poiSearchService.keywordSearch(param);
		} catch (AMapErrorException e) {
			LOGGER.error(e.getError().toString());
		}
		return jsonObject;
	}

	@Override
	public JsonObject aroundSearch(PoiSearch param) {
		JsonObject jsonObject = null;
		try {
			jsonObject = poiSearchService.aroundSearch(param);
		} catch (AMapErrorException e) {
			LOGGER.error(e.getError().toString());
		}
		return jsonObject;
	}

	@Override
	public JsonObject districtSearch(District param) {
		JsonObject jsonObject = null;
		try {
			jsonObject = districtService.districtSearch(param);
		} catch (AMapErrorException e) {
			LOGGER.error(e.getError().toString());
		}
		return jsonObject;
	}

	@Override
	public JsonObject convert(Coordinate coordinate) {
		JsonObject jsonObject = null;
		try {
			jsonObject = coordinateService.convert(coordinate);
		} catch (AMapErrorException e) {
			LOGGER.error(e.getError().toString());
		}
		return jsonObject;
	}

	@Override
	public JsonObject inputTips(InputTips inputTips) {
		JsonObject jsonObject = null;
		try {
			jsonObject = assistantService.inputTips(inputTips);
		} catch (AMapErrorException e) {
			LOGGER.error(e.getError().toString());
		}
		return jsonObject;
	}
}
