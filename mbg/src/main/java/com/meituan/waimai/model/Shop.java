package com.meituan.waimai.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;

public class Shop implements Serializable {
    private Integer id;

    private Integer accountId;

    @ApiModelProperty(value = "商家编号")
    private String shopSn;

    @ApiModelProperty(value = "头像")
    private String picUrl;

    @ApiModelProperty(value = "商店名称")
    private String shopName;

    @ApiModelProperty(value = "电话号码")
    private String phone;

    @ApiModelProperty(value = "城市")
    private Integer city;

    @ApiModelProperty(value = "区")
    private Integer county;

    @ApiModelProperty(value = "地址")
    private String address;

    @ApiModelProperty(value = "起送时间")
    private String shippingTime;

    @ApiModelProperty(value = "配送费")
    private BigDecimal shippingFee;

    @ApiModelProperty(value = "起送价")
    private BigDecimal minPrice;

    @ApiModelProperty(value = "公告")
    private String bulletin;

    @ApiModelProperty(value = "状态")
    private Integer status;

    @ApiModelProperty(value = "商家分类")
    private Integer categoryId;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public String getShopSn() {
        return shopSn;
    }

    public void setShopSn(String shopSn) {
        this.shopSn = shopSn;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getCity() {
        return city;
    }

    public void setCity(Integer city) {
        this.city = city;
    }

    public Integer getCounty() {
        return county;
    }

    public void setCounty(Integer county) {
        this.county = county;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getShippingTime() {
        return shippingTime;
    }

    public void setShippingTime(String shippingTime) {
        this.shippingTime = shippingTime;
    }

    public BigDecimal getShippingFee() {
        return shippingFee;
    }

    public void setShippingFee(BigDecimal shippingFee) {
        this.shippingFee = shippingFee;
    }

    public BigDecimal getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(BigDecimal minPrice) {
        this.minPrice = minPrice;
    }

    public String getBulletin() {
        return bulletin;
    }

    public void setBulletin(String bulletin) {
        this.bulletin = bulletin;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", accountId=").append(accountId);
        sb.append(", shopSn=").append(shopSn);
        sb.append(", picUrl=").append(picUrl);
        sb.append(", shopName=").append(shopName);
        sb.append(", phone=").append(phone);
        sb.append(", city=").append(city);
        sb.append(", county=").append(county);
        sb.append(", address=").append(address);
        sb.append(", shippingTime=").append(shippingTime);
        sb.append(", shippingFee=").append(shippingFee);
        sb.append(", minPrice=").append(minPrice);
        sb.append(", bulletin=").append(bulletin);
        sb.append(", status=").append(status);
        sb.append(", categoryId=").append(categoryId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}