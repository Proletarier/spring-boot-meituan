package com.meituan.waimai.hub.api.map;

import com.google.gson.JsonObject;
import com.meituan.waimai.hub.model.dto.map.PoiSearch;
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
