package com.meituan.waimai.controller;

import com.meituan.waimai.common.domain.CommonPage;
import com.meituan.waimai.common.domain.CommonResult;
import com.meituan.waimai.model.Role;
import com.meituan.waimai.model.RoleMenuRelation;
import com.meituan.waimai.model.RoleResourceRelation;
import com.meituan.waimai.service.RoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "角色管理")
@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @ApiOperation(value = "角色列表")
    @GetMapping(value = "/list")
    public CommonResult<CommonPage<Role>> list(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                               @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                               String keyword) {
        List<Role> list = roleService.list(pageNum, pageSize, keyword);
        return CommonResult.success(CommonPage.restPage(list));
    }

    @ApiOperation(value = "获取用户详情")
    @GetMapping(value = "/{id}")
    public CommonResult<Role> getRole(@PathVariable Integer id) {
        Role role = roleService.getById(id);
        return CommonResult.success(role);
    }

    @ApiOperation(value = "角色添加")
    @PutMapping(value = "/create")
    public CommonResult create(@RequestBody Role role) {
        return  roleService.save(role)? CommonResult.success(): CommonResult.failed();
    }

    @ApiOperation(value = "角色修改")
    @PostMapping(value = "/update")
    public CommonResult update(@RequestBody Role role) {
        return  roleService.updateById(role)? CommonResult.success(): CommonResult.failed();
    }

    @ApiOperation(value = "修改状态")
    @PostMapping(value = "/updateStatus")
    public CommonResult updateStatus(@RequestParam("id") Integer id, @RequestParam("status") Integer status) {
        Role role = new Role();
        role.setId(id);
        role.setStatus(status);
        return roleService.updateById(role)? CommonResult.success(): CommonResult.failed();
    }

    @ApiOperation(value = "角色与菜单对应关系")
    @GetMapping(value = "/menuRelation/{roleId}")
    public CommonResult<List<RoleMenuRelation>> listRoleMenuRelation(@PathVariable Integer roleId) {
        List<RoleMenuRelation> list = roleService.listRoleMenuRelation(roleId);
        return CommonResult.success(list);
    }

    @ApiOperation(value = "角色与资源对应关系")
    @GetMapping(value = "/resourceRelation/{roleId}")
    public CommonResult<List<RoleResourceRelation>> listRoleResourceRelation(@PathVariable Integer roleId) {
        List<RoleResourceRelation> list = roleService.listRoleResourceRelation(roleId);
        return CommonResult.success(list);
    }


    @ApiOperation(value = "分配菜单")
    @PostMapping(value = "/allocMenu")
    public CommonResult allocMenu(@RequestParam("roleId") Integer roleId, @RequestParam("menuIds") List<Integer> menuIds) {
        int count = roleService.allocMenu(roleId, menuIds);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation(value = "分配资源")
    @PostMapping(value = "/allocResource")
    public CommonResult allocResource(@RequestParam("roleId") Integer roleId, @RequestParam("resourceIds") List<Integer> resourceIds) {
        int count = roleService.allocResource(roleId, resourceIds);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }



}
