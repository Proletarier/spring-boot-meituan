package com.meituan.waimai.amap.api.impl;

import com.google.gson.JsonObject;
import com.meituan.waimai.amap.api.AMapService;
import com.meituan.waimai.amap.util.http.HttpType;
import com.meituan.waimai.amap.util.http.RequestHttp;


public  abstract class AMapServiceImpl<H, P> implements AMapService, RequestHttp<H, P> {


	@Override
	public String get(String url, String queryParam) {
		return null;
	}

	@Override
	public String post(String url, String postData) {
		return null;
	}

	@Override
	public String post(String url, JsonObject jsonObject) {
		return null;
	}

	@Override
	public H getRequestHttpClient() {
		return null;
	}

	@Override
	public P getRequestHttpProxy() {
		return null;
	}

	@Override
	public HttpType getRequestType() {
		return null;
	}
}
