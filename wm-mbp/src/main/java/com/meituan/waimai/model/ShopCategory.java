package com.meituan.waimai.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(value="com-meituan-waimai-model-ShopCategory")
@Data
@TableName(value = "wm_shop_category")
public class ShopCategory  extends BaseEntity {
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

    @TableField(value = "is_home")
    @ApiModelProperty(value="")
    private Integer isHome;

}