package com.meituan.waimai.amap.api.impl;

import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.meituan.waimai.amap.api.AMapService;
import com.meituan.waimai.amap.api.IPLocationService;
import com.meituan.waimai.amap.bean.LocationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Map;

import static com.meituan.waimai.amap.enums.AMapUrl.IP.*;

public class IPLocationServiceImpl implements IPLocationService {

	@Autowired
	private AMapService aMapService;

	@Override
	public JSONObject location(LocationRequest param) {
		Gson gson = new GsonBuilder().create();
		Map<String, String>  mapParam = gson.fromJson(gson.toJson(param), Map.class);
		String  json = aMapService.get(IP_LOCATION.getUrl(),mapParam);
		if (StrUtil.isBlank(json)){
		}
		return  null;
	}
}
