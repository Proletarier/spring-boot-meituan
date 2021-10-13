package com.meituan.waimai.mall.server.impl;

import com.meituan.waimai.common.service.RedisService;
import com.meituan.waimai.mall.server.MallCacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

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
	}
}
