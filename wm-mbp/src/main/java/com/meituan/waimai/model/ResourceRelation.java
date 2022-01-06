package com.meituan.waimai.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import lombok.Data;

@ApiModel(value="com-meituan-waimai-model-ResourceRelation")
@Data
@TableName(value = "wm_resource_relation")
public class ResourceRelation extends AbstractEntity {

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