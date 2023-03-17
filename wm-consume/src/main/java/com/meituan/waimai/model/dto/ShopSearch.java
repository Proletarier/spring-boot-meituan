package com.meituan.waimai.model.dto;

public class ShopSearch {

    private Integer limit;
    private Integer nextStartIndex;


    public Integer getNextStartIndex() {
        return nextStartIndex;
    }

    public void setNextStartIndex(Integer nextStartIndex) {
        this.nextStartIndex = nextStartIndex;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }
}
