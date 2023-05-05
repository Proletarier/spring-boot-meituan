package com.meituan.waimai.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "_product_discount")
public class ProductDiscount  extends BaseEntity  {

    @TableField(value = "shop_id")
    private  Integer shopId;

    @TableField(value = "product_id")
    private  Integer productId;

    @TableField(value = "count")
    private  Integer count;

    @TableField(value = "discount")
    private  Double discount;

    @TableField(value = "price")
    private  Double price;
}
