package com.meituan.waimai.po;


import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name="ums_user")
public class User {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="username")
    private String username;

    @Column(name="name")
    private String password;

    @Column(name = "type",columnDefinition="int(1) COMMENT '账号类型: 1->系统人员；2->商家'")
    private Integer type;

    @Column(name="nickName")
    private String nickName;

    @Column(name="phone",unique = true)
    private String phone;

    @Column(name="email")
    private String email;

    @Column(name="note")
    private String note;

    @Column(name="createTime")
    private Date createTime;

    @Column(name="loginTime")
    private Date loginTime;

    @Column(name="status",columnDefinition="int(1) COMMENT '账号类型: 0->禁用；1->启用'")
    private Integer status;

}
