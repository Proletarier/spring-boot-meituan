package com.meituan.waimai.amap.api.impl;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import com.meituan.waimai.amap.util.http.HttpClientPoolUtil;
import com.meituan.waimai.amap.util.http.HttpClientResult;
import com.meituan.waimai.common.error.AMapError;
import com.meituan.waimai.common.error.AMapErrorMsgEnum;
import com.meituan.waimai.common.exception.AMapErrorException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

import java.util.Map;
import java.util.Objects;

public abstract class AbstractAMapService {

	private static final Logger LOGGER = LoggerFactory.getLogger(AbstractAMapService.class);

	@Value("${amap.key}")
	private String key;

	public JsonObject get(String url, Map<String, String> params) throws AMapErrorException {
		HttpClientResult result = null;
		params.put("key",key);
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

}
