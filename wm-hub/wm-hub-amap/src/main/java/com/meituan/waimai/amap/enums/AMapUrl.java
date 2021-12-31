package com.meituan.waimai.amap.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

public interface AMapUrl {

	String API_DEFAULT_HOST_URL = "https://restapi.amap.com";

	default String getUrl() {
		return this.getPrefix() + getPath();
	}

	String getPath();

	String getPrefix();

	@AllArgsConstructor
	@Getter
	enum IP implements AMapUrl {
		/**
		 * ip定位
		 */
		IP_LOCATION(API_DEFAULT_HOST_URL, "/v5/ip");

		private final String prefix;
		private final String path;
	}

	@AllArgsConstructor
	@Getter
	enum Poi implements AMapUrl {
		/**
		 * 周边搜索
		 */
		POI_AROUND_SEARCH(API_DEFAULT_HOST_URL, "/v3/place/around"),
		/**
		 * 关键字搜索
		 */
		POI_KEYWORD_SEARCH(API_DEFAULT_HOST_URL, "/v3/place/text");

		private final String prefix;
		private final String path;
	}

	@AllArgsConstructor
	@Getter
	enum District implements AMapUrl {

		DISTRICT_SEARCH(API_DEFAULT_HOST_URL,"/v3/config/district");

		private final String prefix;
		private final String path;
	}

	@AllArgsConstructor
	@Getter
	enum Coordinate implements AMapUrl{

		COORDINATE_CONVERT(API_DEFAULT_HOST_URL,"/v3/assistant/coordinate/convert");

		private final String prefix;
		private final String path;
	}

	@AllArgsConstructor
	@Getter
	enum Assistant implements AMapUrl{

		ASSISTANT_INPUT_TIPS(API_DEFAULT_HOST_URL,"/v3/assistant/inputtips");

		private final String prefix;
		private final String path;
	}
}
