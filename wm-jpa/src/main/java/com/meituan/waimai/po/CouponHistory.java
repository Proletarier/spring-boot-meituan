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
@Table(name="sms_coupon")
public class CouponHistory {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="coupon_id")
    private Long couponId;

    @Column(name="customer_id")
    private Long customerId;

    @Column(name="customer_code")
    private String couponCode;

    @Column(name="customer_name")
    private String customerName;

    @Column(name="source")
    private Integer source;

    @Column(name="use_status")
    private Integer useStatus;

    @Column(name="use_time")
    private Date useTime;

    @Column(name="order_id")
    private Integer orderId;

    @Column(name="order_sn")
    private String orderSn;

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
