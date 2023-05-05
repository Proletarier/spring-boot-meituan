package com.meituan.waimai.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@TableName(value = "_product_attribute")
public class ProductAttribute extends BaseEntity {

    @TableField(value = "product_attribute_category_id")
    private Integer productAttributeCategoryId;

    @TableField(value = "`name`")
    private String name;

    @TableField(value = "`status`")
    private Integer status;

}