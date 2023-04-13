package com.meituan.waimai.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "_promotion")
public class Discount extends BaseEntity {

    @TableField(value = "shop_id")
    private Long shopId;

    @TableField(value = "promotion_type")
    private String promotionType;

    @TableField(value = "info")
    private String info;
}
