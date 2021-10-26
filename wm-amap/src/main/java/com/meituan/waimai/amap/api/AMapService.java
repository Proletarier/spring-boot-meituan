package com.meituan.waimai.amap.api;

import com.google.gson.JsonObject;

public interface AMapService {

	String get(String url, String queryParam);

	String post(String url, String postData);

	String post(String url, JsonObject jsonObject);
}
