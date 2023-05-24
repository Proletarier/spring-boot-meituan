package com.meituan.waimai.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(value="com-meituan-waimai-model-Role")
@Data
@TableName(value = "wm_role")
public class Role extends BaseEntity {
    /**
     * 名称
     */
    @TableField(value = "`name`")
    @ApiModelProperty(value="名称")
    private String name;

    /**
     * 描述
     */
    @TableField(value = "description")
    @ApiModelProperty(value="描述")
    private String description;

    /**
     * 后台用户数量
     */
    @TableField(value = "admin_count")
    @ApiModelProperty(value="后台用户数量")
    private Integer adminCount;


    /**
     * 启用状态：0->禁用；1->启用
     */
    @TableField(value = "`status`")
    @ApiModelProperty(value="启用状态：0->禁用；1->启用")
    private Integer status;

    @TableField(value = "sort")
    @ApiModelProperty(value="")
    private Integer sort;
}