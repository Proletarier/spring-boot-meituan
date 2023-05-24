package com.meituan.waimai.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "_product_attribute")
public class ProductAttribute extends BaseEntity {

    @TableField(value = "product_attribute_category_id")
    private Integer productAttributeCategoryId;

    @TableField(value = "`name`")
    private String name;

}