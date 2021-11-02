package com.meituan.waimai.amap.api;

import com.google.gson.JsonObject;
import com.meituan.waimai.amap.bean.PoiSearchQuery;
import com.meituan.waimai.amap.error.AMapErrorException;

public interface PoiSearchService   {

	/**
	 * 关键字搜索
	 * @return
	 */
	JsonObject keywordSearch(PoiSearchQuery param) throws AMapErrorException;

	/**
	 * 周边搜索
	 * @param request
	 * @return
	 */
	JsonObject aroundSearch(PoiSearchQuery param) throws AMapErrorException;
}
