package com.meituan.waimai.common.service.map;

import com.google.gson.JsonObject;
import com.meituan.waimai.common.exception.AMapErrorException;
import com.meituan.waimai.common.util.json.GsonHelper;
import com.meituan.waimai.common.model.map.Location;
import org.springframework.stereotype.Service;

import static com.meituan.waimai.common.model.enums.AMapUrl.IP.IP_LOCATION;

@Service
public class IPLocationService extends AbstractAMapService {


	public JsonObject location(Location param) throws AMapErrorException {
		return get(IP_LOCATION.getUrl(),GsonHelper.ObjectToMapString(param));
	}
}
