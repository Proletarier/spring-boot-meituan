package com.meituan.waimai.amap.api;

import com.google.gson.JsonObject;

import java.util.Map;

public interface AMapService {

	String get(String url, Map<String, String> params);

	String post(String url, String postData);
}
