package com.heng.mall.model;


import javax.persistence.*;

@Entity
@Table(name="cms_customer")
public class Customer {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="customerName")
    private String customerName;

    @Column(name="status",columnDefinition="int(1) COMMENT '帐号启用状态:0->禁用；1->启用'")
    private Integer status;

    @Column(name="phone",columnDefinition="varchar(32) COMMENT '电话'")
    private String phone;

    @Column(name="icon",columnDefinition="varchar(100) COMMENT '头像'")
    private String icon;

    @Column(name="type",columnDefinition="int(1) COMMENT '客户类型'")
    private Integer type;

    @Column(name="city",columnDefinition="varchar(20) COMMENT '注册城市'")
    private String city;

    @Column(name="cityCode",columnDefinition="varchar(20) COMMENT '注册城市'")
    private String cityCode;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }
}
