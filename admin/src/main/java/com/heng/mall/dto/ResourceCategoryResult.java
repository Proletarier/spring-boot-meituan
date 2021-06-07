package com.heng.mall.dto;

import com.heng.mall.model.Resource;
import com.heng.mall.model.ResourceCategory;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class ResourceCategoryResult extends ResourceCategory {

    @Getter
    @Setter
    @ApiModelProperty("资源列表")
    private List<Resource>  resourceList;
}
