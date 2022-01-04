package com.meituan.waimai.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import lombok.Data;

@ApiModel(value="com-meituan-waimai-model-AdminUser")
@Data
@TableName(value = "wm_admin_user")
public class AdminUser {
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value="")
    private Integer id;

    @TableField(value = "created_by")
    @ApiModelProperty(value="")
    private String createdBy;

    @TableField(value = "created_date")
    @ApiModelProperty(value="")
    private Date createdDate;

    @TableField(value = "email")
    @ApiModelProperty(value="")
    private String email;

    @TableField(value = "nick_name")
    @ApiModelProperty(value="")
    private String nickName;

    @TableField(value = "note")
    @ApiModelProperty(value="")
    private String note;

    @TableField(value = "`name`")
    @ApiModelProperty(value="")
    private String name;

    @TableField(value = "phone")
    @ApiModelProperty(value="")
    private String phone;

    /**
     * 账号类型: 0->禁用；1->启用
     */
    @TableField(value = "`status`")
    @ApiModelProperty(value="账号类型: 0->禁用；1->启用")
    private Integer status;

    @TableField(value = "updated_by")
    @ApiModelProperty(value="")
    private String updatedBy;

    @TableField(value = "updated_date")
    @ApiModelProperty(value="")
    private Date updatedDate;

    @TableField(value = "username")
    @ApiModelProperty(value="")
    private String username;
}