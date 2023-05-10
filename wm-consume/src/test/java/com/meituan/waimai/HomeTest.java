package com.meituan.waimai;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.meituan.waimai.mapper.FoodMapper;
import com.meituan.waimai.model.vo.FoodMenu;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class  HomeTest {

    @Autowired
    FoodMapper foodMapper;

    @Test
    public  void  getCaptcha(){
    }

}
