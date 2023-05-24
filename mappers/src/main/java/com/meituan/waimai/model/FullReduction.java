package com.meituan.waimai.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "_full_reduction")
public class FullReduction extends BaseEntity {

    @TableField(value = "shop_id")
    private Integer shopId;

    @TableField(value = "full_price")
    private Double fullPrice;

    @TableField(value = "reduce_price")
    private Double reducePrice;

}
