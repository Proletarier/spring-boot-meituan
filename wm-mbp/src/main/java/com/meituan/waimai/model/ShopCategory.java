package com.meituan.waimai.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import lombok.Data;

@ApiModel(value="com-meituan-waimai-model-ShopCategory")
@Data
@TableName(value = "wm_shop_category")
public class ShopCategory  extends AbstractEntity{
    @TableField(value = "`all`")
    @ApiModelProperty(value="")
    private Integer all;

    @TableField(value = "icon")
    @ApiModelProperty(value="")
    private String icon;

    @TableField(value = "`level`")
    @ApiModelProperty(value="")
    private Integer level;

    @TableField(value = "`name`")
    @ApiModelProperty(value="")
    private String name;

    @TableField(value = "parent_id")
    @ApiModelProperty(value="")
    private Integer parentId;

    @TableField(value = "priority")
    @ApiModelProperty(value="")
    private Integer priority;

}