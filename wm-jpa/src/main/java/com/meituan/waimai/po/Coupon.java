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
public class Coupon {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="source")
    private Integer source;

    @Column(name="shop_id")
    private Integer shopId;

    @Column(name="count")
    private Integer count;

    @Column(name="amount")
    private Integer amount;

    @Column(name="per_limit")
    private Integer perLimit;

    @Column(name="minPoint")
    private Integer minPoint;

    @Column(name="startTime")
    private Date startTime;

    @Column(name="endTime")
    private Date endTime;

    @Column(name="useType")
    private Integer useType;

    @Column(name="note")
    private String note;

    @Column(name="publish_count")
    private Integer publishCount;

    @Column(name="use_count")
    private Integer useCount;

    @Column(name="receive_count")
    private Integer receiveCount;

    @Column(name="enable_time")
    private Date enableTime;

    @Column(name="code")
    private String code;

    @Column(name="member_level")
    private Integer memberLevel;

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
