package com.meituan.waimai.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;

public class Product implements Serializable {
    private Integer id;

    private Integer shopId;

    @ApiModelProperty(value = "产品名称")
    private String productName;

    @ApiModelProperty(value = "1-产品 2-套餐")
    private Integer productType;

    @ApiModelProperty(value = "产品分类")
    private Integer productCategoryId;

    @ApiModelProperty(value = "产品图片")
    private String imageUrl;

    @ApiModelProperty(value = "产品介绍")
    private String productDesc;

    @ApiModelProperty(value = "产品点赞")
    private Integer praiseNum;

    @ApiModelProperty(value = "销售状态 1-启用 0-停用")
    private Integer sellStatus;

    @ApiModelProperty(value = "删除状态")
    private Integer deleteStatus;

    @ApiModelProperty(value = "单位（个 克 份）")
    private String unit;

    @ApiModelProperty(value = "销量")
    private Integer sale;

    @ApiModelProperty(value = "平均月销量")
    private Integer monthSale;

    @ApiModelProperty(value = "价格")
    private BigDecimal price;

    @ApiModelProperty(value = "促销价格")
    private BigDecimal promotionPrice;

    @ApiModelProperty(value = "库存")
    private Integer stock;

    @ApiModelProperty(value = "库存预警")
    private Integer lowStock;

    @ApiModelProperty(value = "重量")
    private Double weight;

    @ApiModelProperty(value = "产品分类名称")
    private String productCategoryName;

    @ApiModelProperty(value = "起售数量")
    private Integer minSaleQuantity;

    @ApiModelProperty(value = "排序")
    private Integer sort;

    @ApiModelProperty(value = "打包费")
    private BigDecimal boxPrice;

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

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getProductType() {
        return productType;
    }

    public void setProductType(Integer productType) {
        this.productType = productType;
    }

    public Integer getProductCategoryId() {
        return productCategoryId;
    }

    public void setProductCategoryId(Integer productCategoryId) {
        this.productCategoryId = productCategoryId;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    public Integer getPraiseNum() {
        return praiseNum;
    }

    public void setPraiseNum(Integer praiseNum) {
        this.praiseNum = praiseNum;
    }

    public Integer getSellStatus() {
        return sellStatus;
    }

    public void setSellStatus(Integer sellStatus) {
        this.sellStatus = sellStatus;
    }

    public Integer getDeleteStatus() {
        return deleteStatus;
    }

    public void setDeleteStatus(Integer deleteStatus) {
        this.deleteStatus = deleteStatus;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Integer getSale() {
        return sale;
    }

    public void setSale(Integer sale) {
        this.sale = sale;
    }

    public Integer getMonthSale() {
        return monthSale;
    }

    public void setMonthSale(Integer monthSale) {
        this.monthSale = monthSale;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getPromotionPrice() {
        return promotionPrice;
    }

    public void setPromotionPrice(BigDecimal promotionPrice) {
        this.promotionPrice = promotionPrice;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getLowStock() {
        return lowStock;
    }

    public void setLowStock(Integer lowStock) {
        this.lowStock = lowStock;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public String getProductCategoryName() {
        return productCategoryName;
    }

    public void setProductCategoryName(String productCategoryName) {
        this.productCategoryName = productCategoryName;
    }

    public Integer getMinSaleQuantity() {
        return minSaleQuantity;
    }

    public void setMinSaleQuantity(Integer minSaleQuantity) {
        this.minSaleQuantity = minSaleQuantity;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public BigDecimal getBoxPrice() {
        return boxPrice;
    }

    public void setBoxPrice(BigDecimal boxPrice) {
        this.boxPrice = boxPrice;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", shopId=").append(shopId);
        sb.append(", productName=").append(productName);
        sb.append(", productType=").append(productType);
        sb.append(", productCategoryId=").append(productCategoryId);
        sb.append(", imageUrl=").append(imageUrl);
        sb.append(", productDesc=").append(productDesc);
        sb.append(", praiseNum=").append(praiseNum);
        sb.append(", sellStatus=").append(sellStatus);
        sb.append(", deleteStatus=").append(deleteStatus);
        sb.append(", unit=").append(unit);
        sb.append(", sale=").append(sale);
        sb.append(", monthSale=").append(monthSale);
        sb.append(", price=").append(price);
        sb.append(", promotionPrice=").append(promotionPrice);
        sb.append(", stock=").append(stock);
        sb.append(", lowStock=").append(lowStock);
        sb.append(", weight=").append(weight);
        sb.append(", productCategoryName=").append(productCategoryName);
        sb.append(", minSaleQuantity=").append(minSaleQuantity);
        sb.append(", sort=").append(sort);
        sb.append(", boxPrice=").append(boxPrice);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}