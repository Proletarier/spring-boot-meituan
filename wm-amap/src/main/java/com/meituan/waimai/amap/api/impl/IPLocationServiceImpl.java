package com.meituan.waimai.amap.api.impl;

import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.meituan.waimai.amap.api.AMapService;
import com.meituan.waimai.amap.api.IPLocationService;
import com.meituan.waimai.amap.bean.LocationRequest;
import com.meituan.waimai.amap.error.AMapError;
import com.meituan.waimai.amap.error.AMapErrorException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;
import java.util.Objects;

import static com.meituan.waimai.amap.enums.AMapUrl.IP.*;

public class IPLocationServiceImpl implements IPLocationService {

	@Autowired
	private AMapService aMapService;

	@Override
	public JsonObject location(LocationRequest param) throws AMapErrorException {
		Gson gson = new GsonBuilder().create();
		Map<String, String> mapParam = gson.fromJson(gson.toJson(param), Map.class);
		String json = aMapService.get(IP_LOCATION.getUrl(), mapParam);

		if (Objects.isNull(json)) {
			throw new AMapErrorException("网络异常，请稍后重试");
		}

		JsonObject jsonObject = JsonParser.parseString(json).getAsJsonObject();
		if (!"1".equals(jsonObject.get("status").getAsString())) {
			throw new AMapErrorException(AMapError.fromJson(json));
		}

		return jsonObject;
	}
}
