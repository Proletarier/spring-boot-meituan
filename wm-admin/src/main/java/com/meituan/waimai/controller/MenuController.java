package com.meituan.waimai.controller;

import com.meituan.waimai.common.domain.CommonPage;
import com.meituan.waimai.common.domain.CommonResult;
import com.meituan.waimai.dto.SystemMenuNode;
import com.meituan.waimai.model.SystemMenu;
import com.meituan.waimai.service.MenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "菜单")
@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;


    @ApiOperation(value = "菜单列表")
    @GetMapping(value = "/list")
    public CommonResult<CommonPage<SystemMenu>> list(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                                     @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                     Integer parentId) {
        List<SystemMenu> list = menuService.list(pageNum, pageSize,parentId);
        return CommonResult.success(CommonPage.restPage(list));
    }

    @ApiOperation(value = "查询菜单及其子类")
    @GetMapping(value = "/tree")
    public CommonResult<List<SystemMenuNode>> treeMenuList() {
        List<SystemMenuNode> list = menuService.treeMenuList();
        return CommonResult.success(list);
    }


    @ApiOperation(value = "获取菜单详情")
    @GetMapping(value = "/{id}")
    public CommonResult<SystemMenu> getRole(@PathVariable Integer id) {
        SystemMenu systemMenu = menuService.getById(id);
        return CommonResult.success(systemMenu);
    }

    @ApiOperation(value = "菜单添加")
    @PutMapping(value = "/create")
    public CommonResult create(@RequestBody SystemMenu systemMenu) {
        return menuService.create(systemMenu)? CommonResult.success(): CommonResult.failed();
    }

    @ApiOperation(value = "菜单修改")
    @PostMapping(value = "/update")
    public CommonResult update(@RequestBody SystemMenu systemMenu) {
        return  menuService.updateById(systemMenu) ? CommonResult.success(): CommonResult.failed();
    }

}
