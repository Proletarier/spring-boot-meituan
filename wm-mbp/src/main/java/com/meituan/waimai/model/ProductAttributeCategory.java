package com.meituan.waimai.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "_product_attribute_category")
public class ProductAttributeCategory extends BaseEntity {

    @TableField(value = "shop_id")
    private Integer shopId;

    @TableField(value = "name")
    private String categoryName;

}