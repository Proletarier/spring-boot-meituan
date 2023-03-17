package com.meituan.waimai.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(value="com-meituan-waimai-model-GoodsMenu")
@Data
@TableName(value = "wm_goods_menu")
public class GoodsMenu extends BaseEntity {

    @TableField(value = "icon")
    @ApiModelProperty(value="")
    private String icon;

    @TableField(value = "`name`")
    @ApiModelProperty(value="")
    private String name;

    @TableField(value = "shop_id")
    @ApiModelProperty(value="")
    private Integer shopId;

    @TableField(value = "sort")
    @ApiModelProperty(value="")
    private Integer sort;

    @TableField(value = "status")
    @ApiModelProperty(value="")
    private Integer status;

}