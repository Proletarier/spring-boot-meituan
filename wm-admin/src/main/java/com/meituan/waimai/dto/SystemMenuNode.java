package com.meituan.waimai.dto;

import com.meituan.waimai.model.SystemMenu;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class SystemMenuNode extends SystemMenu {

    @Getter
    @Setter
    @ApiModelProperty("子菜单")
    private List<SystemMenuNode> children;
}
