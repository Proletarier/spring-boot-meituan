package com.meituan.waimai.amap.api;

import com.alibaba.fastjson.JSONObject;
import com.meituan.waimai.amap.bean.PoiSearchRequest;

public interface PoiSearchService  {

	/**
	 * 关键字搜索
	 * @return
	 */
	 JSONObject keywordSearch(PoiSearchRequest request);

	/**
	 * 周边搜索
	 * @param request
	 * @return
	 */
	 JSONObject aroundSearch(PoiSearchRequest request);
}
