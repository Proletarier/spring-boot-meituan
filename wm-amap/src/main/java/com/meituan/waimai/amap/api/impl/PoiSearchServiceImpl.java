package com.meituan.waimai.amap.api.impl;

import com.alibaba.fastjson.JSONObject;
import com.meituan.waimai.amap.api.PoiSearchService;
import com.meituan.waimai.amap.bean.PoiSearchRequest;
import org.springframework.stereotype.Service;

@Service
public class PoiSearchServiceImpl implements PoiSearchService {

	@Override
	public JSONObject keywordSearch(PoiSearchRequest request) {
		return null;
	}

	@Override
	public JSONObject aroundSearch(PoiSearchRequest request) {
		return null;
	}
}
