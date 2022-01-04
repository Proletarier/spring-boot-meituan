package com.meituan.waimai.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import lombok.Data;

@ApiModel(value="com-meituan-waimai-model-Dictionary")
@Data
@TableName(value = "wm_dictionary")
public class Dictionary {
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value="")
    private Integer id;

    @TableField(value = "choice")
    @ApiModelProperty(value="")
    private Integer choice;

    @TableField(value = "created_by")
    @ApiModelProperty(value="")
    private String createdBy;

    @TableField(value = "created_date")
    @ApiModelProperty(value="")
    private Date createdDate;

    @TableField(value = "dic_desc")
    @ApiModelProperty(value="")
    private String dicDesc;

    @TableField(value = "dic_key")
    @ApiModelProperty(value="")
    private String dicKey;

    @TableField(value = "dic_value")
    @ApiModelProperty(value="")
    private String dicValue;

    @TableField(value = "icon")
    @ApiModelProperty(value="")
    private String icon;

    @TableField(value = "is_lock")
    @ApiModelProperty(value="")
    private Integer isLock;

    /**
     * 帐号启用状态:0->禁用；1->启用
     */
    @TableField(value = "`status`")
    @ApiModelProperty(value="帐号启用状态:0->禁用；1->启用")
    private Integer status;

    @TableField(value = "updated_by")
    @ApiModelProperty(value="")
    private String updatedBy;

    @TableField(value = "updated_date")
    @ApiModelProperty(value="")
    private Date updatedDate;
}