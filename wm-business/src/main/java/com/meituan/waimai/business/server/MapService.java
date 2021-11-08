package com.meituan.waimai.business.server;

import com.google.gson.JsonObject;
import com.meituan.waimai.amap.bean.*;

public interface MapService {

	JsonObject location(Location param);

	JsonObject keywordSearch(PoiSearch param);

	JsonObject aroundSearch(PoiSearch param);

	JsonObject districtSearch(District param);

	JsonObject convert(Coordinate coordinate);

	JsonObject inputTips(InputTips inputTips);

}
