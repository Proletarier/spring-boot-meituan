package com.meituan.waimai.model.vo;

import com.alibaba.fastjson.JSONArray;

import java.util.List;

public class FilterConditions {

    private JSONArray multifilterVOList;
    private JSONArray sortVOList;

    public JSONArray getMultifilterVOList() {
        return multifilterVOList;
    }

    public void setMultifilterVOList(JSONArray multifilterVOList) {
        this.multifilterVOList = multifilterVOList;
    }

    public JSONArray getSortVOList() {
        return sortVOList;
    }

    public void setSortVOList(JSONArray sortVOList) {
        this.sortVOList = sortVOList;
    }
}
