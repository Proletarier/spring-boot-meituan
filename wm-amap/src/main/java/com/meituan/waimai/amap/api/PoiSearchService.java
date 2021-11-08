package com.meituan.waimai.amap.api;

import com.google.gson.JsonObject;
import com.meituan.waimai.amap.bean.PoiSearch;
import com.meituan.waimai.common.exception.AMapErrorException;

public interface PoiSearchService   {

	/**
	 * 关键字搜索
	 * @return
	 */
	JsonObject keywordSearch(PoiSearch param) throws AMapErrorException;

	/**
	 * 周边搜索
	 * @param request
	 * @return
	 */
	JsonObject aroundSearch(PoiSearch param)  throws AMapErrorException;
}
