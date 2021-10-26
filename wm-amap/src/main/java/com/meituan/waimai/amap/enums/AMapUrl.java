package com.meituan.waimai.amap.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

public class AMapUrl {

	public static final String API_DEFAULT_HOST_URL = "https://restapi.amap.com";

	@AllArgsConstructor
	@Getter
	enum IP {
		/**
		 * ip定位
		 */
		IP_LOCATION(API_DEFAULT_HOST_URL,"/v5/ip");

		private final String prefix;
		private final String path;
	}

	@AllArgsConstructor
	@Getter
	enum Poi {
		/**
		 * 周边搜索
		 */
		POI_AROUND_SEARCH(API_DEFAULT_HOST_URL,"/v3/place/around"),
		/**
		 * 关键字搜索
		 */
		POI_KEYWORD_SEARCH(API_DEFAULT_HOST_URL,"/v3/place/text");

		private final String prefix;
		private final String path;
	}
}
