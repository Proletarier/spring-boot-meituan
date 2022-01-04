package com.meituan.waimai.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import lombok.Data;

@ApiModel(value="com-meituan-waimai-model-Role")
@Data
@TableName(value = "wm_role")
public class Role {
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value="")
    private Integer id;

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
     * 创建时间
     */
    @TableField(value = "create_time")
    @ApiModelProperty(value="创建时间")
    private Date createTime;

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