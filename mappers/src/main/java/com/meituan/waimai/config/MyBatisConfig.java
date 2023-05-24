package com.meituan.waimai.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.meituan.waimai.handler.UpdateObjectHandler;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@MapperScan({"com.meituan.waimai.*"})
public class MyBatisConfig {

    @Bean
    public MetaObjectHandler updateObjectHandler() {
        return new UpdateObjectHandler();
    }
}
