package com.meituan.waimai.common;

import java.util.HashMap;
import java.util.Map;

public class WmContext {
	private static final ThreadLocal<Map<String, Object>> CONTEXT_HOLDER = new ThreadLocal<>();
	private static final String KEY_USER_ID = "user_id";
	private static final String KEY_USER_ACCOUNT = "user_phone";
	private static final String KEY_USER_NAME = "user_name";
	private static final String KEY_REQUEST_HEADER = "request_header";

	private static synchronized Map<String, Object> getCurrentMap() {
		Map<String, Object> map = CONTEXT_HOLDER.get();
		if (map == null) {
			map = new HashMap<>(16);
			CONTEXT_HOLDER.set(map);
		}
		return map;
	}

	private static synchronized void put(String key, Object value) {
		Map<String, Object> map = getCurrentMap();
		map.put(key, value);
	}

	private static synchronized <T> T get(String key) {
		return (T) getCurrentMap().get(key);
	}

	public static void clearHmContext() {
		CONTEXT_HOLDER.remove();
	}

	/**
	 * 设置当前用户ID
	 *
	 * @param userId
	 */
	public static void setUserID(Integer userId) {
		WmContext.put(WmContext.KEY_USER_ID, userId);
	}

	/**
	 * 获取当前用户ID
	 *
	 * @return
	 */
	public static Integer getUserId() {
		return WmContext.get(WmContext.KEY_USER_ID);
	}

	/**
	 * 设置当前用户账号
	 *
	 * @param account
	 */
	public static void setUserAccount(String account) {
		WmContext.put(WmContext.KEY_USER_ACCOUNT, account);
	}

	/**
	 * 获取当前用户账号
	 *
	 * @return
	 */
	public static String getKeyUserAccount() {
		return WmContext.get(WmContext.KEY_USER_ACCOUNT);
	}

	/**
	 * 设置当前用户名称
	 *
	 * @param userName
	 */
	public static void setUserName(String userName) {
		WmContext.put(WmContext.KEY_USER_NAME, userName);
	}

	/**
	 * 获取当前用户名称
	 *
	 * @return
	 */
	public static String getUserName() {
		return WmContext.get(WmContext.KEY_USER_NAME);
	}

	/**
	 * 保存请求头
	 *
	 * @param key
	 * @param value
	 */
	public static void putReqHeader(String key, String value) {
		Map<String, String> map = WmContext.get(WmContext.KEY_REQUEST_HEADER);
		if (map == null) {
			map = new HashMap<>();
		}
		map.put(key, value);
		WmContext.put(WmContext.KEY_REQUEST_HEADER, map);
	}

	/**
	 * 获取所有请求头
	 *
	 * @return
	 */
	public static Map<String, String> getReqHeaders() {
		Map<String, String> map = WmContext.get(WmContext.KEY_REQUEST_HEADER);
		if (map == null) {
			map = new HashMap<>();
			WmContext.put(WmContext.KEY_REQUEST_HEADER, map);
		}
		return map;
	}

	/**
	 * 获取单个请求头
	 *
	 * @param key
	 * @return
	 */
	public static String getReqHeader(String key) {
		Map<String, String> map = WmContext.get(WmContext.KEY_REQUEST_HEADER);
		if (map == null) {
			map = new HashMap<>();
			WmContext.put(WmContext.KEY_REQUEST_HEADER, map);
		}
		return map.get(key);
	}

}
