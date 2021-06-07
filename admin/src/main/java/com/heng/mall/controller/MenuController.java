package com.heng.mall.controller;

import com.heng.mall.common.api.CommonPage;
import com.heng.mall.common.api.CommonResult;
import com.heng.mall.dto.MenuNode;
import com.heng.mall.model.Menu;
import com.heng.mall.service.MenuService;
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
    public CommonResult<CommonPage<Menu>> list(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                               @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                               Integer parentId) {
        List<Menu> list = menuService.list(pageNum, pageSize,parentId);
        return CommonResult.success(CommonPage.restPage(list));
    }

    @ApiOperation(value = "查询菜单及其子类")
    @GetMapping(value = "/tree")
    public CommonResult<List<MenuNode>> treeMenuList() {
        List<MenuNode> list = menuService.treeMenuList();
        return CommonResult.success(list);
    }


    @ApiOperation(value = "获取菜单详情")
    @GetMapping(value = "/{id}")
    public CommonResult<Menu> getRole(@PathVariable Integer id) {
        Menu menu = menuService.getMenu(id);
        return CommonResult.success(menu);
    }

    @ApiOperation(value = "菜单添加")
    @PutMapping(value = "/create")
    public CommonResult create(@RequestBody Menu menu) {
        int count = menuService.create(menu);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }

    }

    @ApiOperation(value = "菜单修改")
    @PostMapping(value = "/update")
    public CommonResult update(@RequestBody Menu menu) {
        int count = menuService.update(menu);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

}
