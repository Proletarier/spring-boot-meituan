package com.meituan.waimai.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "_menu")
public class Menu extends BaseEntity {

    @TableField(value = "shop_id")
    private Integer shopId;

    @TableField(value = "icon")
    private String icon;

    @TableField(value = "`menu_name`")
    private String menuName;

    @TableField(value = "status")
    private Integer status;

    @TableField(value = "sort")
    private Integer sort;

}