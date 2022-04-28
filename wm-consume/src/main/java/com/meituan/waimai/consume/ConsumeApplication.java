package com.meituan.waimai.consume;


import com.meituan.waimai.consume.controller.LoginController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication(scanBasePackages = "com.meituan.waimai")
public class ConsumeApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context =  SpringApplication.run(ConsumeApplication.class, args);
    }

}
