package com.meituan.waimai.common.api;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.meituan.waimai.common.error.AMapError;
import com.meituan.waimai.common.error.AMapErrorMsgEnum;
import com.meituan.waimai.common.exception.AMapErrorException;
import com.meituan.waimai.common.model.map.*;
import com.meituan.waimai.common.util.HttpClientPoolUtil;
import com.meituan.waimai.common.util.HttpClientResult;
import com.meituan.waimai.common.util.json.GsonHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Objects;

import static com.meituan.waimai.common.model.enums.AMapUrl.Assistant.ASSISTANT_INPUT_TIPS;
import static com.meituan.waimai.common.model.enums.AMapUrl.Coordinate.COORDINATE_CONVERT;
import static com.meituan.waimai.common.model.enums.AMapUrl.District.DISTRICT_SEARCH;
import static com.meituan.waimai.common.model.enums.AMapUrl.IP.IP_LOCATION;
import static com.meituan.waimai.common.model.enums.AMapUrl.Poi.POI_AROUND_SEARCH;
import static com.meituan.waimai.common.model.enums.AMapUrl.Poi.POI_KEYWORD_SEARCH;

@Service
public class  MapService {

    @Value("${amap.key}")
    private String key;

    private static final Logger LOGGER = LoggerFactory.getLogger(MapService.class);

    public JsonObject get(String url, Map<String, String> params) throws AMapErrorException {
        params.put("key",key);
        HttpClientResult result = null;
        try {
            LOGGER.info("------map-> get -> url = {},params = {}",url,params);
            result = HttpClientPoolUtil.doGet(url,params,true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (Objects.isNull(result)){
            AMapError error = AMapError.builder().errorMsg(AMapErrorMsgEnum.MAP_99999.getCode()).errorMsg(AMapErrorMsgEnum.MAP_99999.getMsg()).build();
            throw new AMapErrorException(error);
        }
        JsonObject jsonObject = JsonParser.parseString(result.getContent()).getAsJsonObject();
        if (!"1".equals(jsonObject.get("status").getAsString())) {
            throw new AMapErrorException(AMapError.fromJson(result.getContent()));
        }
        return jsonObject;
    }

    public String post(String url, String postData) throws AMapErrorException {
        HttpClientResult result = null;
        try {
            result = HttpClientPoolUtil.doPost(url,null,postData,true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (Objects.isNull(result)){
            AMapError error = AMapError.builder().errorMsg(AMapErrorMsgEnum.MAP_99999.getCode()).errorMsg(AMapErrorMsgEnum.MAP_99999.getMsg()).build();
            throw new AMapErrorException(error);
        }
        return result.getContent();
    }


    public JsonObject keywordSearch(PoiSearch request) throws AMapErrorException {
        return get(POI_KEYWORD_SEARCH.getUrl(), GsonHelper.ObjectToMapString(request));
    }


    public JsonObject aroundSearch(PoiSearch request) throws AMapErrorException {
        return get(POI_AROUND_SEARCH.getUrl(), GsonHelper.ObjectToMapString(request));
    }

    public JsonObject location(Location param) throws AMapErrorException {
        return get(IP_LOCATION.getUrl(),GsonHelper.ObjectToMapString(param));
    }

    public JsonObject districtSearch(District param) throws AMapErrorException {
        return  get(DISTRICT_SEARCH.getUrl(), GsonHelper.ObjectToMapString(param));
    }

    public JsonObject convert(Coordinate coordinate) throws AMapErrorException {
        return get(COORDINATE_CONVERT.getUrl(), GsonHelper.ObjectToMapString(coordinate));
    }

    public JsonObject inputTips(InputTips inputTips) throws AMapErrorException {
        return  get(ASSISTANT_INPUT_TIPS.getUrl(), GsonHelper.ObjectToMapString(inputTips));
    }


}
