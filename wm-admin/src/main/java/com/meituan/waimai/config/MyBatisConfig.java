package com.meituan.waimai.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@MapperScan({"com.meituan.waimai.mapper", "com.meituan.waimai.dao"})
public class MyBatisConfig {
}
