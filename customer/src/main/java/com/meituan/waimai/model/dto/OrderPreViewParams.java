package com.meituan.waimai.model.dto;

import lombok.Data;

import java.util.List;

@Data
public class OrderPreViewParams {

    private  List<FoodSpec> foodList;
    private Integer shopId;


    @Data
    public static class FoodSpec {
        private Integer foodId;
        private Integer count;
        private Integer[] attrIds;
    }
}
