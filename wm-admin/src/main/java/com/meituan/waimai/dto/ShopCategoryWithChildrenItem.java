package com.meituan.waimai.dto;

import com.meituan.waimai.model.ShopCategory;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class ShopCategoryWithChildrenItem extends ShopCategory {

    @Getter
    @Setter
    @ApiModelProperty("子集")
    private List<ShopCategory> children;
}
