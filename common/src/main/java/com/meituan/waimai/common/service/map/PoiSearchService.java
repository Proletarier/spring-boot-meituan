package com.meituan.waimai.common.service.map;

import com.google.gson.JsonObject;
import com.meituan.waimai.common.exception.AMapErrorException;
import com.meituan.waimai.common.util.json.GsonHelper;
import com.meituan.waimai.common.model.map.PoiSearch;
import org.springframework.stereotype.Service;

import static com.meituan.waimai.common.model.enums.AMapUrl.Poi.POI_AROUND_SEARCH;
import static com.meituan.waimai.common.model.enums.AMapUrl.Poi.POI_KEYWORD_SEARCH;

@Service
public class PoiSearchService extends AbstractAMapService  {


	public JsonObject keywordSearch(PoiSearch request) throws AMapErrorException {
		return get(POI_KEYWORD_SEARCH.getUrl(), GsonHelper.ObjectToMapString(request));
	}


	public JsonObject aroundSearch(PoiSearch request) throws AMapErrorException {
		return get(POI_AROUND_SEARCH.getUrl(), GsonHelper.ObjectToMapString(request));
	}
}
