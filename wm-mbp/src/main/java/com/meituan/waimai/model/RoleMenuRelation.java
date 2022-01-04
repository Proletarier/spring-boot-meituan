package com.meituan.waimai.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(value="com-meituan-waimai-model-RoleMenuRelation")
@Data
@TableName(value = "wm_role_menu_relation")
public class RoleMenuRelation {
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value="")
    private Integer id;

    @TableField(value = "role_id")
    @ApiModelProperty(value="")
    private Integer roleId;

    @TableField(value = "menu_id")
    @ApiModelProperty(value="")
    private Integer menuId;
}