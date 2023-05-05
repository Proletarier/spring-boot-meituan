package com.meituan.waimai.model.vo;

import lombok.Data;

import java.util.List;

@Data
public class FoodCategory {

    private String categoryName;
    private String iconUrl;
    private List<Food> subList;
}
