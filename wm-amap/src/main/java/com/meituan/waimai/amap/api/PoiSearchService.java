package com.meituan.waimai.amap.api;

import com.google.gson.JsonObject;
import com.meituan.waimai.amap.bean.PoiSearchRequest;

public interface PoiSearchService  {

	/**
	 * 关键字搜索
	 * @return
	 */
	JsonObject keywordSearch(PoiSearchRequest request);

	/**
	 * 周边搜索
	 * @param request
	 * @return
	 */
	JsonObject aroundSearch(PoiSearchRequest request);
}
