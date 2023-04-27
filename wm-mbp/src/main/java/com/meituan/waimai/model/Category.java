package com.meituan.waimai.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(autoResultMap = true,value = "_category")
public class Category extends BaseEntity {

    @TableField(value = "`name`")
    private String name;

    @TableField(value = "parent_id")
    private Integer parentId;

    @TableField(value = "`icon`")
    private String icon;

    @TableField(value = "count")
    private Integer count;

    @TableField(value = "is_home")
    private Boolean isHome;

    @TableField(value = "pre_id")
    private Integer preId;
}
