package com.meituan.waimai.consume.config;

import com.meituan.waimai.consume.Interceptor.ContextInterceptor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class WebConfiguration implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(contextInterceptor());
    }

    @Bean
    public HandlerInterceptor contextInterceptor(){
        return  new ContextInterceptor();
    }

    @Bean
    @ConfigurationProperties(prefix = "jwt.ignored.urls")
    List<String> jwtIgnoredUrls() {
        return new ArrayList<>();
    }

}