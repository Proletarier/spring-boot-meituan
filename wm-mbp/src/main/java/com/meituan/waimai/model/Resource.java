package com.meituan.waimai.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import lombok.Data;

@ApiModel(value="com-meituan-waimai-model-Resource")
@Data
@TableName(value = "wm_resource")
public class Resource {
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value="")
    private Integer id;

    @TableField(value = "category_id")
    @ApiModelProperty(value="")
    private Integer categoryId;

    @TableField(value = "description")
    @ApiModelProperty(value="")
    private String description;

    @TableField(value = "`name`")
    @ApiModelProperty(value="")
    private String name;

    @TableField(value = "url")
    @ApiModelProperty(value="")
    private String url;

    @TableField(value = "sort")
    @ApiModelProperty(value="")
    private Integer sort;

    @TableField(value = "`status`")
    @ApiModelProperty(value="")
    private Integer status;
}