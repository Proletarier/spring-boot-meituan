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
@Table(name="sms_shop_license")
public class ShopLicense {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="shop_id")
    private Integer shopId;

    @Column(name="idacrd_name")
    private String idacrdName;

    @Column(name="idcard_num")
    private String idcardNum;

    @Column(name="idcard_img")
    private String idcardImg;

    @Column(name="qualify_pics")
    private String qualifyPics;

    @Column(name="company_name")
    private String companyName;

    @Column(name="company_owner")
    private String companyOwner;

    @Column(name="business_scope")
    private String businessScope;

    @Column(name="address")
    private String address;

    @Column(name="enroll_time")
    private Date enrollTime;

    @Column(name="expire_time")
    private Date expireTime;

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
