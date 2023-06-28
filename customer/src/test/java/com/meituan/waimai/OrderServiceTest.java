package com.meituan.waimai;
import cn.hutool.core.lang.Assert;
import com.alibaba.fastjson.JSONObject;
import com.meituan.waimai.bean.CustomerContext;
import com.meituan.waimai.model.dto.OrderPreViewParams.FoodSpec;
import com.meituan.waimai.model.vo.OrderDetail;
import com.meituan.waimai.server.OrderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class OrderServiceTest {

    @Autowired
    OrderService orderService;

    @Test
    public void preViewOrder(){

        List<FoodSpec> specList = new ArrayList<>();
        FoodSpec spec = new FoodSpec();
        spec.setFoodId(30);
        spec.setCount(2);
        spec.setAttrIds(new Integer[] {51,57});
        specList.add(spec);

        FoodSpec spec2 = new FoodSpec();
        spec2.setFoodId(31);
        spec2.setCount(5);
        specList.add(spec2);

        CustomerContext.setCustomerId(1);
        CustomerContext.setKeyCustomerTelephone("18780027522");

        OrderDetail orderDetail =  orderService.preViewOrder(1,specList);
        Assert.notNull(orderDetail);
        System.out.println(JSONObject.toJSONString(orderDetail));

    }
}
