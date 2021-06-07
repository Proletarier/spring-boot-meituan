package com.heng.mall.dto;

import com.heng.mall.model.ShopCategory;
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
