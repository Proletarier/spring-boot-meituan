package com.meituan.waimai.consume.model.dto;

import io.swagger.annotations.ApiModelProperty;

public class CustomerInfo {

    private Integer id;
    @ApiModelProperty(value = "头像")
    private String face;
    @ApiModelProperty(value = "昵称")
    private String name;
    @ApiModelProperty(value = "是否会员")
    private boolean member;
    @ApiModelProperty(value = "token")
    private String token;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFace() {
        return face;
    }

    public void setFace(String face) {
        this.face = face;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isMember() {
        return member;
    }

    public void setMember(boolean member) {
        this.member = member;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
