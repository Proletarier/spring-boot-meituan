package com.heng.mall.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class Region implements Serializable {
    @ApiModelProperty(value = "区域主键")
    private Integer id;

    @ApiModelProperty(value = "区域名称")
    private String name;

    @ApiModelProperty(value = "区域上级标识")
    private Integer pid;

    @ApiModelProperty(value = "地名简称")
    private String sname;

    @ApiModelProperty(value = "区域等级")
    private Integer level;

    @ApiModelProperty(value = "区域编码")
    private String cityCode;

    @ApiModelProperty(value = "邮政编码")
    private String yzcode;

    @ApiModelProperty(value = "组合名称")
    private String mername;

    private Float lng;

    private Float lat;

    private String pinyin;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getYzcode() {
        return yzcode;
    }

    public void setYzcode(String yzcode) {
        this.yzcode = yzcode;
    }

    public String getMername() {
        return mername;
    }

    public void setMername(String mername) {
        this.mername = mername;
    }

    public Float getLng() {
        return lng;
    }

    public void setLng(Float lng) {
        this.lng = lng;
    }

    public Float getLat() {
        return lat;
    }

    public void setLat(Float lat) {
        this.lat = lat;
    }

    public String getPinyin() {
        return pinyin;
    }

    public void setPinyin(String pinyin) {
        this.pinyin = pinyin;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", pid=").append(pid);
        sb.append(", sname=").append(sname);
        sb.append(", level=").append(level);
        sb.append(", cityCode=").append(cityCode);
        sb.append(", yzcode=").append(yzcode);
        sb.append(", mername=").append(mername);
        sb.append(", lng=").append(lng);
        sb.append(", lat=").append(lat);
        sb.append(", pinyin=").append(pinyin);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}