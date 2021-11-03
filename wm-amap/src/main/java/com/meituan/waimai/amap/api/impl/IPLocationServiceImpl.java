package com.meituan.waimai.amap.api.impl;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.meituan.waimai.amap.api.AMapService;
import com.meituan.waimai.amap.api.IPLocationService;
import com.meituan.waimai.amap.bean.Location;
import com.meituan.waimai.amap.error.AMapError;
import com.meituan.waimai.amap.error.AMapErrorException;
import com.meituan.waimai.common.util.json.GsonHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import static com.meituan.waimai.amap.enums.AMapUrl.IP.*;

@Service
public class IPLocationServiceImpl implements IPLocationService {

	@Autowired
	private AMapService aMapService;

	@Override
	public JsonObject location(Location param) throws Exception {
		String json = aMapService.get(IP_LOCATION.getUrl(),GsonHelper.ObjectToMapString(param));
		JsonObject jsonObject = JsonParser.parseString(json).getAsJsonObject();
		if (!"1".equals(jsonObject.get("status").getAsString())) {
			throw new AMapErrorException(AMapError.fromJson(json));
		}
		return jsonObject;
	}

}
