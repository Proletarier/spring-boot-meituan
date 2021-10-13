package com.meituan.waimai.po;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="cms_customer")
public class Customer {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="customerName")
    private String userName;

    @Column(name="status",columnDefinition="int(1) COMMENT '帐号启用状态:0->禁用；1->启用'")
    private Integer status;

    @Column(name="phone",unique=true,nullable = false, length = 32)
    private String phone;

    @Column(name="face",length = 100)
    private String face;

}
