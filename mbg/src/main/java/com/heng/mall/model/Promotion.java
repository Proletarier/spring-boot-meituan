package com.heng.mall.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class Promotion implements Serializable {
    private Integer id;

    @ApiModelProperty(value = "1-优惠活动 2 商家特色")
    private Integer promotionType;

    @ApiModelProperty(value = "推广名称")
    private String name;

    @ApiModelProperty(value = "图标")
    private String icon;

    @ApiModelProperty(value = "模板")
    private String promotionTemplate;

    @ApiModelProperty(value = "描述")
    private String description;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPromotionType() {
        return promotionType;
    }

    public void setPromotionType(Integer promotionType) {
        this.promotionType = promotionType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getPromotionTemplate() {
        return promotionTemplate;
    }

    public void setPromotionTemplate(String promotionTemplate) {
        this.promotionTemplate = promotionTemplate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", promotionType=").append(promotionType);
        sb.append(", name=").append(name);
        sb.append(", icon=").append(icon);
        sb.append(", promotionTemplate=").append(promotionTemplate);
        sb.append(", description=").append(description);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}