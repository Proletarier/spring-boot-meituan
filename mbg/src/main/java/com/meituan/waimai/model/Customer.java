package com.meituan.waimai.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class Customer implements Serializable {
    private Long id;

    @ApiModelProperty(value = "昵称")
    private String cutomerName;

    @ApiModelProperty(value = "帐号启用状态:0->禁用；1->启用")
    private Integer status;

    @ApiModelProperty(value = "电话")
    private String phone;

    @ApiModelProperty(value = "头像")
    private String icon;

    @ApiModelProperty(value = "客户类型")
    private Integer type;

    @ApiModelProperty(value = "注册城市")
    private String city;

    @ApiModelProperty(value = "注册城市")
    private String cityCode;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCutomerName() {
        return cutomerName;
    }

    public void setCutomerName(String cutomerName) {
        this.cutomerName = cutomerName;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", cutomerName=").append(cutomerName);
        sb.append(", status=").append(status);
        sb.append(", phone=").append(phone);
        sb.append(", icon=").append(icon);
        sb.append(", type=").append(type);
        sb.append(", city=").append(city);
        sb.append(", cityCode=").append(cityCode);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}