package com.meituan.waimai.amap.api.impl;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.meituan.waimai.amap.api.AMapService;
import com.meituan.waimai.amap.util.http.HttpClientPoolUtil;
import com.meituan.waimai.amap.util.http.HttpClientResult;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service
public  class AMapServiceImpl implements AMapService {


	@Override
	public String get(String url, Map<String, String> params) {
		HttpClientResult result = null;
		try {
			result = HttpClientPoolUtil.doGet(url,params,true);
		} catch (Exception e) {
			e.printStackTrace();
			return  null;
		}
		return result.getContent();
	}

	@Override
	public String post(String url, String postData) {
		HttpClientResult result = null;
		try {
			result = HttpClientPoolUtil.doPost(url,null,postData,true);
		} catch (Exception e) {
			e.printStackTrace();
			return  null;
		}
		return result.getContent();
	}



}
