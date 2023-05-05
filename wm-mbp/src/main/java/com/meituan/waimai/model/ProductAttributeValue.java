package com.meituan.waimai.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "_product_attribute_value")
public class ProductAttributeValue extends BaseEntity {

    @TableField(value = "product_id")
    private Integer productId;

    @TableField(value = "product_attribute_category_id")
    private Integer productAttributeCategoryId;

    @TableField(value = "product_attribute_id")
    private Integer productAttributeId;

}