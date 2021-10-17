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
@Table(name="sms_coupon_product_category_relation")
public class CouponShopCateRelation {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="coupon_id")
    private Integer couponId;

    @Column(name="shop_category_id")
    private Integer shopCategoryId;

    @Column(name="shop_category_name")
    private String shopCategoryName;

    @Column(name="parent_category_name")
    private String parentCategoryName;

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
