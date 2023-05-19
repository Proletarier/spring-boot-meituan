package com.meituan.waimai.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "_comment")
public class Comment extends BaseEntity {


    @TableField(value = "`order_id`")
    private Integer orderId;

    @TableField(value = "`customer_id`")
    private Integer customerId;

    @TableField(value = "`shop_id`")
    private Integer shopId;

    @TableField(value = "customer_name")
    private String customerName;

    @TableField(value = "customer_icon")
    private String customerIcon;

    @TableField(value = "delivery_time")
    private String deliveryTime;

    @TableField(value = "praise_dish")
    private String praiseDish;

    @TableField(value = "`content`")
    private String content;

    @TableField(value = "`shop_reply`")
    private String shopReply;

    @TableField(value = "`pictures`")
    private String pictures;

    @TableField(value = "`score`")
    private Integer score;

    @TableField(value = "labels")
    private String labels;

}
