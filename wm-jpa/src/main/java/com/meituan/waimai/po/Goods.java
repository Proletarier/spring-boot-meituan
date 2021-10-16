package com.meituan.waimai.po;


import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name="sms_goods")
public class Goods {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private Integer goodsId;

    @Column(name="shop_id")
    private Integer shopId;

    @Column(name="name")
    private String name;

    @Column(name="tag_ids")
    private String tagIds;

    @Column(name="picture")
    private String picture;

    @Column(name="goods_desc")
    private String goodsDesc;

    @Column(name="sell_status")
    private Integer sellStatus;

    @Column(name="unit")
    private String unit;

    @Column(name="price")
    private Integer price;

    @CreatedDate
    @Column(name = "created_date", updatable = false)
    private Date createdDate;

    @CreatedBy
    @Column(name = "created_by", updatable = false, length = 64)
    private String createdBy;

    @LastModifiedDate
    @Column(name = "updated_date")
    private Date updatedDate;

    @LastModifiedBy
    @Column(name = "updated_by", length = 64)
    private String updatedBy;
}
