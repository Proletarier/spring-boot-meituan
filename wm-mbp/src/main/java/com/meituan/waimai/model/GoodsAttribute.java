package com.meituan.waimai.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(value="com-meituan-waimai-model-GoodsAttribute")
@Data
@TableName(value = "wm_goods_attribute")
public class GoodsAttribute extends BaseEntity {

    @TableField(value = "goods_attribute_category_id")
    @ApiModelProperty(value="")
    private Integer goodsAttributeCategoryId;

    @TableField(value = "`name`")
    @ApiModelProperty(value="")
    private String name;

    @TableField(value = "sort")
    @ApiModelProperty(value="")
    private Integer sort;

    @TableField(value = "`status`")
    @ApiModelProperty(value="")
    private Integer status;

}