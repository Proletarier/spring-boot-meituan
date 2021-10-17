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
@Table(name="cms_custoemr")
public class Customer {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="customer_name")
    private String customerName;

    @Column(name="status",columnDefinition="int(1) COMMENT '帐号启用状态:0->禁用；1->启用'")
    private Integer status;

    @Column(name="phone",unique=true,nullable = false, length = 32)
    private String phone;

    @Column(name="face",length = 100)
    private String face;

    @Column(name="is_member")
    private Integer isMember;

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
