package com.meituan.waimai.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class OrderComments implements Serializable {
    private Long id;

    private Long shopId;

    private Long customerId;

    @ApiModelProperty(value = "评价内容")
    private String content;

    @ApiModelProperty(value = "评价日期")
    private Date commentTime;

    @ApiModelProperty(value = "上传图片")
    private String pictures;

    @ApiModelProperty(value = "总体分数")
    private BigDecimal score;

    @ApiModelProperty(value = "包装分数")
    private BigDecimal packScore;

    @ApiModelProperty(value = "口味评分")
    private BigDecimal qualityScore;

    @ApiModelProperty(value = "配送评分")
    private BigDecimal deliveryScore;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(Date commentTime) {
        this.commentTime = commentTime;
    }

    public String getPictures() {
        return pictures;
    }

    public void setPictures(String pictures) {
        this.pictures = pictures;
    }

    public BigDecimal getScore() {
        return score;
    }

    public void setScore(BigDecimal score) {
        this.score = score;
    }

    public BigDecimal getPackScore() {
        return packScore;
    }

    public void setPackScore(BigDecimal packScore) {
        this.packScore = packScore;
    }

    public BigDecimal getQualityScore() {
        return qualityScore;
    }

    public void setQualityScore(BigDecimal qualityScore) {
        this.qualityScore = qualityScore;
    }

    public BigDecimal getDeliveryScore() {
        return deliveryScore;
    }

    public void setDeliveryScore(BigDecimal deliveryScore) {
        this.deliveryScore = deliveryScore;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", shopId=").append(shopId);
        sb.append(", customerId=").append(customerId);
        sb.append(", content=").append(content);
        sb.append(", commentTime=").append(commentTime);
        sb.append(", pictures=").append(pictures);
        sb.append(", score=").append(score);
        sb.append(", packScore=").append(packScore);
        sb.append(", qualityScore=").append(qualityScore);
        sb.append(", deliveryScore=").append(deliveryScore);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}