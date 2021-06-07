package com.heng.mall.dto;

import com.heng.mall.model.Region;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class RegionWithChildrenItem extends Region {

    @Getter
    @Setter
    @ApiModelProperty("子集")
    private List<Region> children;
}
