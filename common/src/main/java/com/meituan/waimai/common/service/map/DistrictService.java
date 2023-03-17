package com.meituan.waimai.common.service.map;

import com.google.gson.JsonObject;
import com.meituan.waimai.common.exception.AMapErrorException;
import com.meituan.waimai.common.util.json.GsonHelper;
import com.meituan.waimai.common.model.map.District;
import org.springframework.stereotype.Service;

import static com.meituan.waimai.common.model.enums.AMapUrl.District.DISTRICT_SEARCH;

@Service
public class DistrictService extends AbstractAMapService {


	public JsonObject districtSearch(District param) throws AMapErrorException {
		return  get(DISTRICT_SEARCH.getUrl(), GsonHelper.ObjectToMapString(param));
	}
}
