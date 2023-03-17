package com.meituan.waimai.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(value="com-meituan-waimai-model-ResourceCategory")
@Data
@TableName(value = "wm_resource_category")
public class ResourceCategory extends BaseEntity {

    @TableField(value = "`name`")
    @ApiModelProperty(value="")
    private String name;

    @TableField(value = "sort")
    @ApiModelProperty(value="")
    private Integer sort;

}