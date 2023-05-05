package com.meituan.waimai.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(value="com-meituan-waimai-model-SystemMenu")
@Data
@TableName(value = "wm_menu")
public class SystemMenu extends BaseEntity {

    @TableField(value = "hidden")
    @ApiModelProperty(value="")
    private Integer hidden;

    @TableField(value = "icon")
    @ApiModelProperty(value="")
    private String icon;

    @TableField(value = "`level`")
    @ApiModelProperty(value="")
    private Integer level;

    @TableField(value = "`name`")
    @ApiModelProperty(value="")
    private String name;

    @TableField(value = "parent_id")
    @ApiModelProperty(value="")
    private Integer parentId;

    @TableField(value = "`position`")
    @ApiModelProperty(value="")
    private Integer position;

    @TableField(value = "sort")
    @ApiModelProperty(value="")
    private Integer sort;

    @TableField(value = "title")
    @ApiModelProperty(value="")
    private String title;

    @TableField(value = "`type`")
    @ApiModelProperty(value="")
    private Integer type;

}