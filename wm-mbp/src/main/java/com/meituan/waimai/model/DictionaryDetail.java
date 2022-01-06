package com.meituan.waimai.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import lombok.Data;

@ApiModel(value="com-meituan-waimai-model-DictionaryDetail")
@Data
@TableName(value = "wm_dictionary_detail")
public class DictionaryDetail {

    @TableField(value = "detail_desc")
    @ApiModelProperty(value="")
    private String detailDesc;

    @TableField(value = "detail_key")
    @ApiModelProperty(value="")
    private String detailKey;

    @TableField(value = "detail_value")
    @ApiModelProperty(value="")
    private String detailValue;

    @TableField(value = "dic_id")
    @ApiModelProperty(value="")
    private String dicId;

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

}