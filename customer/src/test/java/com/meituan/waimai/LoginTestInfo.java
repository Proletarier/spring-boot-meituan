package com.meituan.waimai;

import com.meituan.waimai.controller.LoginController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class LoginTestInfo {

    @Autowired
    LoginController loginController;


    @Test
    public  void  getCaptcha(){
        loginController.getCaptcha("13888888888");
    }
}
