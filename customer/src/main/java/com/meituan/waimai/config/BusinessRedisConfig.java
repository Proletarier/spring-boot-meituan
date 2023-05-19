package com.meituan.waimai.config;

import com.meituan.waimai.common.config.BaseRedisConfig;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;

@EnableCaching
@Configuration
public class BusinessRedisConfig extends BaseRedisConfig {
}
