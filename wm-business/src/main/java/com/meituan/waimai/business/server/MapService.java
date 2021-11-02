package com.meituan.waimai.business.server;

import com.google.gson.JsonObject;
import com.meituan.waimai.amap.bean.LocationQuery;
import com.meituan.waimai.amap.bean.PoiSearchQuery;

public interface MapService {

	JsonObject location(LocationQuery param);

	JsonObject keywordSearch(PoiSearchQuery param);

	JsonObject aroundSearch(PoiSearchQuery param);
}
