package com.meituan.waimai.business.server.impl;

import com.google.gson.JsonObject;
import com.meituan.waimai.amap.api.IPLocationService;
import com.meituan.waimai.amap.api.PoiSearchService;
import com.meituan.waimai.amap.bean.LocationRequest;
import com.meituan.waimai.amap.error.AMapErrorException;
import com.meituan.waimai.business.server.MapService;
import com.meituan.waimai.common.RequestUtil;
import org.apache.commons.lang3.text.StrTokenizer;
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
	public JsonObject location(LocationRequest param) {
		JsonObject jsonObject = null;
		param.setIp(RequestUtil.getRequestIp(request));
		try {
			jsonObject = ipLocationService.location(param);
		} catch (AMapErrorException e) {
			e.printStackTrace();
		}
		return jsonObject;
	}

}
