package com.meituan.waimai.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan("com.meituan.waimai.po")
@EnableJpaRepositories("com.meituan.waimai.repository")
public class JpaConfiguration {
}
