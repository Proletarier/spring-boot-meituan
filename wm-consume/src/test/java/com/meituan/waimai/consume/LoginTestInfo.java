package com.meituan.waimai.consume;

import com.meituan.waimai.consume.controller.LoginController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class LoginTestInfo {

    @Autowired
    LoginController  loginController;


    @Test
    public  void  getCaptcha(){
        loginController.getCaptcha("18780027522");
    }
}
