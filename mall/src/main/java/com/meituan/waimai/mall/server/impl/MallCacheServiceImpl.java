package com.meituan.waimai.mall.server.impl;

import com.meituan.waimai.common.service.RedisService;
import com.meituan.waimai.common.util.DateUtil;
import com.meituan.waimai.mall.server.MallCacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


import java.util.HashMap;
import java.util.Map;


@Service
public class MallCacheServiceImpl implements MallCacheService {

	@Autowired
	private RedisService redisService;

	@Value("${redis.database}")
	private String REDIS_DATABASE;
	@Value("${redis.expire.common}")
	private Long REDIS_EXPIRE;
	@Value("${redis.key.captcha}")
	private String REDIS_KEY_CAPTCHA;


	@Override
	public String getCaptcha(String phone) {
		String key = REDIS_DATABASE + ":" + REDIS_KEY_CAPTCHA + ":" + phone;
		return (String) redisService.get(key);
	}

	@Override
	public void setCaptcha(String phone, String captcha) {
		String key = REDIS_DATABASE + ":" + REDIS_KEY_CAPTCHA + ":" + phone;
		redisService.set(key, captcha, 300);
		updateCaptchaAliveTime(phone);
	}

	@Override
	public Integer getSendCaptchaCount(String phone) {
		String key = phone + ":" + REDIS_DATABASE + ":" + REDIS_KEY_CAPTCHA;
		return (Integer) redisService.hGet(key, "count");
	}

	@Override
	public Long getSendCaptchaLastTime(String phone) {
		String key = phone + ":" + REDIS_DATABASE + ":" + REDIS_KEY_CAPTCHA;
		return (Long) redisService.hGet(key, "last_time");
	}

	protected void updateCaptchaAliveTime(String phone) {
		String key = phone + ":" + REDIS_DATABASE + ":" + REDIS_KEY_CAPTCHA;
		if (redisService.hasKey(key)) {
			redisService.hIncr(phone, "count", 1L);
			redisService.hIncr(phone, "last_time", DateUtil.getCurrentSeconds());
		} else {
			Map map = new HashMap();
			map.put("count", 1);
			map.put("last_time", DateUtil.getCurrentSeconds());
			redisService.hSetAll(key, map, DateUtil.getSecondsNextEarlyMorning());
		}
	}
}
