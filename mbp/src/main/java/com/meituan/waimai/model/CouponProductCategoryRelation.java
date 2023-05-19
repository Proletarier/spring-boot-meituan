package com.meituan.waimai.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(value="com-meituan-waimai-model-CouponProductCategoryRelation")
@Data
@TableName(value = "wm_coupon_product_category_relation")
public class CouponProductCategoryRelation extends BaseEntity {

    @TableField(value = "coupon_id")
    @ApiModelProperty(value="")
    private Integer couponId;

    @TableField(value = "parent_category_name")
    @ApiModelProperty(value="")
    private String parentCategoryName;

    @TableField(value = "shop_category_id")
    @ApiModelProperty(value="")
    private Integer shopCategoryId;

    @TableField(value = "shop_category_name")
    @ApiModelProperty(value="")
    private String shopCategoryName;
}