package com.meituan.waimai.model.dto;

import com.meituan.waimai.validation.shop.ValidExistShop;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class OrderPreViewParams {


    @NotNull
    @ValidExistShop
    private Integer shopId;
    private Integer customerCouponId;
    @NotNull
    private  List<FoodSpec> foodList;

    @Data
    public static class FoodSpec {
        private Integer foodId;
        private Integer count;
        private Integer[] attrIds;
    }
}
