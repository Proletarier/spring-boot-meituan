package com.meituan.waimai.amap.api.impl;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.meituan.waimai.amap.api.AMapService;
import com.meituan.waimai.amap.api.IPLocationService;
import com.meituan.waimai.amap.bean.LocationRequest;
import com.meituan.waimai.amap.error.AMapError;
import com.meituan.waimai.amap.error.AMapErrorException;
import com.meituan.waimai.common.util.json.GsonHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


import static com.meituan.waimai.amap.enums.AMapUrl.IP.*;

@Service
public class IPLocationServiceImpl implements IPLocationService {

	@Autowired
	private AMapService aMapService;

	@Value("${amap.key:6af7985ab67e64b8c6d0c87eec1aa40a}")
	private String key;

	@Override
	public JsonObject location(LocationRequest param) throws AMapErrorException {

		param.setKey(key);
		String json = aMapService.get(IP_LOCATION.getUrl(),GsonHelper.ObjectToMapString(param));

		JsonObject jsonObject = JsonParser.parseString(json).getAsJsonObject();
		if (!"1".equals(jsonObject.get("status").getAsString())) {
			throw new AMapErrorException(AMapError.fromJson(json));
		}

		return jsonObject;
	}
}
