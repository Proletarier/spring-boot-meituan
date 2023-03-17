package com.meituan.waimai.bean;


import java.util.HashMap;
import java.util.Map;

public class CustomerContext {
	private static final ThreadLocal<Map<String, Object>> CONTEXT_HOLDER = new ThreadLocal<>();
	private static final String KEY_CUSTOMER_ID = "customer_id";
	private static final String KEY_CUSTOMER_TELEPHONE = "customer_telephone";
	private static final String KEY_CUSTOMER_NAME = "customer_name";
	private static final String KEY_REQUEST_HEADER = "request_header";
	private static final String KEY_is_member = "is_member";

	private static Map<String, Object> getCurrentMap() {
		Map<String, Object> map = CONTEXT_HOLDER.get();
		if (map == null) {
			synchronized (CustomerContext.class){
				map = new HashMap<>(16);
				CONTEXT_HOLDER.set(map);
			}
		}
		return map;
	}

	private static void put(String key, Object value) {
		Map<String, Object> map = getCurrentMap();
		map.put(key, value);
	}

	private static <T> T get(String key) {
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
	public static void setCustomerId(Integer customerId) {
		CustomerContext.put(CustomerContext.KEY_CUSTOMER_ID, customerId);
	}

	/**
	 * 获取当前用户ID
	 *
	 * @return
	 */
	public static Integer getCustomerId() {
		return CustomerContext.get(CustomerContext.KEY_CUSTOMER_ID);
	}

	/**
	 * 设置当前用户电话号码
	 *
	 * @param account
	 */
	public static void setKeyCustomerTelephone(String phone) {
		CustomerContext.put(CustomerContext.KEY_CUSTOMER_TELEPHONE, phone);
	}

	/**
	 * 获取当前电话号码
	 *
	 * @return
	 */
	public static String getKeyCustomerTelephone() {
		return CustomerContext.get(CustomerContext.KEY_CUSTOMER_TELEPHONE);
	}

	/**
	 * 设置当前用户名称
	 *
	 * @param userName
	 */
	public static void setKeyCustomerName(String customerName) {
		CustomerContext.put(CustomerContext.KEY_CUSTOMER_NAME, customerName);
	}

	/**
	 * 获取当前用户名称
	 *
	 * @return
	 */
	public static String getCustomerName() {
		return CustomerContext.get(CustomerContext.KEY_CUSTOMER_NAME);
	}

	/**
	 * 保存请求头
	 *
	 * @param key
	 * @param value
	 */
	public static void putReqHeader(String key, String value) {
		Map<String, String> map = CustomerContext.get(CustomerContext.KEY_REQUEST_HEADER);
		if (map == null) {
			map = new HashMap<>();
		}
		map.put(key, value);
		CustomerContext.put(CustomerContext.KEY_REQUEST_HEADER, map);
	}

	/**
	 * 获取所有请求头
	 *
	 * @return
	 */
	public static Map<String, String> getReqHeaders() {
		Map<String, String> map = CustomerContext.get(CustomerContext.KEY_REQUEST_HEADER);
		if (map == null) {
			map = new HashMap<>();
			CustomerContext.put(CustomerContext.KEY_REQUEST_HEADER, map);
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
		Map<String, String> map = CustomerContext.get(CustomerContext.KEY_REQUEST_HEADER);
		if (map == null) {
			map = new HashMap<>();
			CustomerContext.put(CustomerContext.KEY_REQUEST_HEADER, map);
		}
		return map.get(key);
	}
}
