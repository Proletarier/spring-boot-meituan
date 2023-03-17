package com.meituan.waimai.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(value="com-meituan-waimai-model-AdminRoleRelation")
@Data
@TableName(value = "wm_admin_role_relation")
public class AdminRoleRelation extends BaseEntity {

    @TableField(value = "admin_id")
    @ApiModelProperty(value="")
    private Integer adminId;

    @TableField(value = "role_id")
    @ApiModelProperty(value="")
    private Integer roleId;

}