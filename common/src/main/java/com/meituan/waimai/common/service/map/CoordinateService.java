package com.meituan.waimai.common.service.map;

import com.google.gson.JsonObject;
import com.meituan.waimai.common.exception.AMapErrorException;
import com.meituan.waimai.common.util.json.GsonHelper;
import com.meituan.waimai.common.model.map.Coordinate;
import org.springframework.stereotype.Service;

import static com.meituan.waimai.common.model.enums.AMapUrl.Coordinate.COORDINATE_CONVERT;

@Service
public class CoordinateService extends AbstractAMapService {


	public JsonObject convert(Coordinate coordinate) throws AMapErrorException {
		return get(COORDINATE_CONVERT.getUrl(), GsonHelper.ObjectToMapString(coordinate));
	}
}
