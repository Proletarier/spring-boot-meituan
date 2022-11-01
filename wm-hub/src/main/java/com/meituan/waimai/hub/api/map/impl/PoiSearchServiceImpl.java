package com.meituan.waimai.hub.api.map.impl;

import com.google.gson.JsonObject;
import com.meituan.waimai.hub.api.map.PoiSearchService;
import com.meituan.waimai.hub.model.dto.map.PoiSearch;
import com.meituan.waimai.common.exception.AMapErrorException;
import com.meituan.waimai.common.util.json.GsonHelper;
import org.springframework.stereotype.Service;

import static com.meituan.waimai.hub.enums.AMapUrl.Poi.*;

@Service
public class PoiSearchServiceImpl extends AbstractAMapService implements PoiSearchService {

	@Override
	public JsonObject keywordSearch(PoiSearch request) throws AMapErrorException {
		return get(POI_KEYWORD_SEARCH.getUrl(), GsonHelper.ObjectToMapString(request));
	}

	@Override
	public JsonObject aroundSearch(PoiSearch request) throws AMapErrorException {
		return get(POI_AROUND_SEARCH.getUrl(), GsonHelper.ObjectToMapString(request));
	}
}
