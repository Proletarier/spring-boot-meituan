package com.meituan.waimai.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;

public class ProductSkuStock implements Serializable {
    private Integer id;

    private Integer productId;

    private Integer attrId;

    @ApiModelProperty(value = "活动库存")
    private String activityStock;

    @ApiModelProperty(value = "实际库存")
    private String realStock;

    @ApiModelProperty(value = "销售状态")
    private String soldStatus;

    @ApiModelProperty(value = "说明")
    private String spec;

    @ApiModelProperty(value = "原价")
    private BigDecimal originPrice;

    @ApiModelProperty(value = "现价")
    private BigDecimal currentPrice;

    @ApiModelProperty(value = "包装费")
    private BigDecimal boxFee;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getAttrId() {
        return attrId;
    }

    public void setAttrId(Integer attrId) {
        this.attrId = attrId;
    }

    public String getActivityStock() {
        return activityStock;
    }

    public void setActivityStock(String activityStock) {
        this.activityStock = activityStock;
    }

    public String getRealStock() {
        return realStock;
    }

    public void setRealStock(String realStock) {
        this.realStock = realStock;
    }

    public String getSoldStatus() {
        return soldStatus;
    }

    public void setSoldStatus(String soldStatus) {
        this.soldStatus = soldStatus;
    }

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec;
    }

    public BigDecimal getOriginPrice() {
        return originPrice;
    }

    public void setOriginPrice(BigDecimal originPrice) {
        this.originPrice = originPrice;
    }

    public BigDecimal getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(BigDecimal currentPrice) {
        this.currentPrice = currentPrice;
    }

    public BigDecimal getBoxFee() {
        return boxFee;
    }

    public void setBoxFee(BigDecimal boxFee) {
        this.boxFee = boxFee;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", productId=").append(productId);
        sb.append(", attrId=").append(attrId);
        sb.append(", activityStock=").append(activityStock);
        sb.append(", realStock=").append(realStock);
        sb.append(", soldStatus=").append(soldStatus);
        sb.append(", spec=").append(spec);
        sb.append(", originPrice=").append(originPrice);
        sb.append(", currentPrice=").append(currentPrice);
        sb.append(", boxFee=").append(boxFee);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}