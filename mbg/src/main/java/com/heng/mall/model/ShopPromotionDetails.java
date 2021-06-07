package com.heng.mall.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class ShopPromotionDetails implements Serializable {
    private Integer id;

    private Integer promotionId;

    private Integer promotionType;

    private Integer shopId;

    @ApiModelProperty(value = "活动描述")
    private String description;

    @ApiModelProperty(value = "活动名称")
    private String promotionName;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPromotionId() {
        return promotionId;
    }

    public void setPromotionId(Integer promotionId) {
        this.promotionId = promotionId;
    }

    public Integer getPromotionType() {
        return promotionType;
    }

    public void setPromotionType(Integer promotionType) {
        this.promotionType = promotionType;
    }

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPromotionName() {
        return promotionName;
    }

    public void setPromotionName(String promotionName) {
        this.promotionName = promotionName;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", promotionId=").append(promotionId);
        sb.append(", promotionType=").append(promotionType);
        sb.append(", shopId=").append(shopId);
        sb.append(", description=").append(description);
        sb.append(", promotionName=").append(promotionName);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}