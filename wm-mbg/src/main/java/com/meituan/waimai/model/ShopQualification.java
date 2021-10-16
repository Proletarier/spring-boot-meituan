package com.meituan.waimai.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class ShopQualification implements Serializable {
    private Integer id;

    private Integer shopId;

    @ApiModelProperty(value = "经营证书")
    private String qualifyPics;

    @ApiModelProperty(value = "公司名称")
    private String companyName;

    @ApiModelProperty(value = "法人")
    private String companyOwner;

    @ApiModelProperty(value = "经营范围")
    private String businessScope;

    @ApiModelProperty(value = "公司地址")
    private String address;

    @ApiModelProperty(value = "注册日期")
    private Date enrollTime;

    @ApiModelProperty(value = "过期时间")
    private Date expireTime;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    public String getQualifyPics() {
        return qualifyPics;
    }

    public void setQualifyPics(String qualifyPics) {
        this.qualifyPics = qualifyPics;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyOwner() {
        return companyOwner;
    }

    public void setCompanyOwner(String companyOwner) {
        this.companyOwner = companyOwner;
    }

    public String getBusinessScope() {
        return businessScope;
    }

    public void setBusinessScope(String businessScope) {
        this.businessScope = businessScope;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getEnrollTime() {
        return enrollTime;
    }

    public void setEnrollTime(Date enrollTime) {
        this.enrollTime = enrollTime;
    }

    public Date getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Date expireTime) {
        this.expireTime = expireTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", shopId=").append(shopId);
        sb.append(", qualifyPics=").append(qualifyPics);
        sb.append(", companyName=").append(companyName);
        sb.append(", companyOwner=").append(companyOwner);
        sb.append(", businessScope=").append(businessScope);
        sb.append(", address=").append(address);
        sb.append(", enrollTime=").append(enrollTime);
        sb.append(", expireTime=").append(expireTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}