package com.meituan.waimai.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "_coupon_shop_category_relation")
public class CouponShopCategoryRelation extends BaseEntity {

    @TableField(value = "coupon_id")
    private Integer couponId;

    @TableField(value = "shop_category_id")
    private Integer shopCategoryId;

}