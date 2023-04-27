package com.meituan.waimai.model.vo;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class FoodMenu {
    private Integer cateId;
    private String icon;
    private String name;
}
