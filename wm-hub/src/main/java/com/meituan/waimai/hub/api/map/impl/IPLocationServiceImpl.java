package com.meituan.waimai.hub.api.map.impl;

import com.google.gson.JsonObject;
import com.meituan.waimai.hub.api.map.IPLocationService;
import com.meituan.waimai.hub.model.dto.map.Location;
import com.meituan.waimai.common.exception.AMapErrorException;
import com.meituan.waimai.common.util.json.GsonHelper;
import org.springframework.stereotype.Service;


import static com.meituan.waimai.hub.enums.AMapUrl.IP.*;

@Service
public class IPLocationServiceImpl extends AbstractAMapService implements IPLocationService {

	@Override
	public JsonObject location(Location param) throws AMapErrorException {
		return get(IP_LOCATION.getUrl(),GsonHelper.ObjectToMapString(param));
	}
}
