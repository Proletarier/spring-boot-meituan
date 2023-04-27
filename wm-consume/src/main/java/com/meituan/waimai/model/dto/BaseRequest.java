package com.meituan.waimai.model.dto;


import com.meituan.waimai.bean.GeoPoint;
import lombok.Data;

@Data
public class BaseRequest {

    private GeoPoint location;

}
