package com.meituan.waimai.amap.api;

import com.meituan.waimai.amap.error.AMapErrorException;

import java.util.Map;

public interface AMapService {

	String get(String url, Map<String, String> params) throws Exception;

	String post(String url, String postData) throws Exception;
}
