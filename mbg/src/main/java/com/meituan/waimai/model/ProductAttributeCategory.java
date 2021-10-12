package com.meituan.waimai.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class ProductAttributeCategory implements Serializable {
    private Integer id;

    private Integer shopId;

    @ApiModelProperty(value = "属性选择类型：1->单选；2->多选")
    private String selectType;

    private String name;

    @ApiModelProperty(value = "属性数量")
    private Integer count;

    @ApiModelProperty(value = "删除状态 1 删除")
    private Integer deleteStatus;

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

    public String getSelectType() {
        return selectType;
    }

    public void setSelectType(String selectType) {
        this.selectType = selectType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getDeleteStatus() {
        return deleteStatus;
    }

    public void setDeleteStatus(Integer deleteStatus) {
        this.deleteStatus = deleteStatus;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", shopId=").append(shopId);
        sb.append(", selectType=").append(selectType);
        sb.append(", name=").append(name);
        sb.append(", count=").append(count);
        sb.append(", deleteStatus=").append(deleteStatus);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}