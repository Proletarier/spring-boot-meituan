package com.meituan.waimai.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 分类查询参数
 */
@Data
public class ShopCategoryQueryParam {
    @ApiModelProperty("父级id")
    private Integer parentId;
}
