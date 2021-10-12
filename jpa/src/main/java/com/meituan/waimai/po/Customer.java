package com.meituan.waimai.po;


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

    @Column(name="phone",unique=true,nullable = false, length = 32)
    private String phone;

    @Column(name="icon",length = 100)
    private String icon;

    @Column(name="type")
    private Integer type;

    @Column(name="city",length = 20)
    private String city;

    @Column(name="cityCode",length = 32)
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
