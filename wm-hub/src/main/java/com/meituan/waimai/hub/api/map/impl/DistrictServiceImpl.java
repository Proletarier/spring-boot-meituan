package com.meituan.waimai.hub.api.map.impl;

import com.google.gson.JsonObject;
import com.meituan.waimai.hub.api.map.DistrictService;
import com.meituan.waimai.hub.model.dto.map.District;
import com.meituan.waimai.common.exception.AMapErrorException;
import com.meituan.waimai.common.util.json.GsonHelper;
import org.springframework.stereotype.Service;

import static com.meituan.waimai.hub.enums.AMapUrl.District.DISTRICT_SEARCH;

@Service
public class DistrictServiceImpl extends AbstractAMapService implements DistrictService {

	@Override
	public JsonObject districtSearch(District param) throws AMapErrorException {
		return  get(DISTRICT_SEARCH.getUrl(), GsonHelper.ObjectToMapString(param));
	}
}
