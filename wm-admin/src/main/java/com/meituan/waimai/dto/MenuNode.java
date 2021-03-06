package com.meituan.waimai.dto;

import com.meituan.waimai.model.Menu;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class MenuNode extends Menu {

    @Getter
    @Setter
    @ApiModelProperty("子菜单")
    private List<MenuNode> children;
}
