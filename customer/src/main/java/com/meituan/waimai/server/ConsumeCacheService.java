package com.meituan.waimai.server;

import com.meituan.waimai.common.api.RedisService;
import com.meituan.waimai.common.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


import java.util.HashMap;
import java.util.Map;
import java.util.Optional;


@Service
public class ConsumeCacheService {

	@Autowired
	private RedisService redisService;

	@Value("${redis.database}")
	private String REDIS_DATABASE;
	@Value("${redis.expire.common}")
	private Long REDIS_EXPIRE;
	@Value("${redis.key.captcha}")
	private String REDIS_KEY_CAPTCHA;

	public String getCaptcha(String phone) {
		String key = REDIS_DATABASE + ":" + REDIS_KEY_CAPTCHA + ":" + phone;
		return (String) redisService.get(key);
	}

	public void setCaptcha(String phone, String captcha) {
		String key = REDIS_DATABASE + ":" + REDIS_KEY_CAPTCHA + ":" + phone;
		redisService.set(key, captcha, 300);
		updateCaptchaAliveTime(phone);
	}

	public Integer getSendCaptchaCount(String phone) {
		String key = phone + ":" + REDIS_DATABASE + ":" + REDIS_KEY_CAPTCHA;
		Optional<Object> value = Optional.ofNullable(redisService.hGet(key, "count"));
		return (Integer) value.orElse(0);
	}

	public Long getSendCaptchaLastTime(String phone) {
		String key = phone + ":" + REDIS_DATABASE + ":" + REDIS_KEY_CAPTCHA;
		Optional<Object> value = Optional.ofNullable(redisService.hGet(key, "last_time"));
		return Long.parseLong(value.orElse(0).toString());
	}

	protected void updateCaptchaAliveTime(String phone) {
		String key = phone + ":" + REDIS_DATABASE + ":" + REDIS_KEY_CAPTCHA;
		if (redisService.hasKey(key)) {
			redisService.hIncr(key, "count", 1L);
			redisService.hSet(key, "last_time", DateUtil.getCurrentSeconds());
		} else {
			Map map = new HashMap();
			map.put("count", 1);
			map.put("last_time", DateUtil.getCurrentSeconds());
			redisService.hSetAll(key, map, DateUtil.getSecondsNextEarlyMorning());
		}
	}
}
