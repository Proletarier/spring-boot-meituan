package com.meituan.waimai.bean;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class GeoPoint implements Serializable {


    @NotNull
    private Double lat;
    @NotNull
    private Double lng;

    public GeoPoint(double lat, double lng) {
        this.lat = lat;
        this.lng = lng;
    }

}
