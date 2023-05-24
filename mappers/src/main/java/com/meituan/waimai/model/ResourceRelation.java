package com.meituan.waimai.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(value="com-meituan-waimai-model-ResourceRelation")
@Data
@TableName(value = "wm_resource_relation")
public class ResourceRelation extends BaseEntity {

    @TableField(value = "menu_id")
    @ApiModelProperty(value="")
    private Integer menuId;

    @TableField(value = "role_id")
    @ApiModelProperty(value="")
    private Integer roleId;

    @TableField(value = "resource_id")
    @ApiModelProperty(value="")
    private Integer resourceId;
}