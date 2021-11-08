package com.meituan.waimai.amap.api.impl;

import com.meituan.waimai.amap.api.AMapService;
import com.meituan.waimai.amap.util.http.HttpClientPoolUtil;
import com.meituan.waimai.amap.util.http.HttpClientResult;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service
public  class AMapServiceImpl implements AMapService {

	@Override
	public String get(String url, Map<String, String> params) throws Exception {
		HttpClientResult result = null;
		result = HttpClientPoolUtil.doGet(url,params,true);
		return result.getContent();
	}

	@Override
	public String post(String url, String postData) throws Exception {
		HttpClientResult result = null;
		result = HttpClientPoolUtil.doPost(url,null,postData,true);
		return result.getContent();
	}

}
