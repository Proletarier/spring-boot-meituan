package com.meituan.waimai.controller;


import cn.hutool.core.collection.CollUtil;
import com.meituan.waimai.common.domain.CommonPage;
import com.meituan.waimai.common.domain.CommonResult;
import com.meituan.waimai.dto.AdminLoginParam;
import com.meituan.waimai.model.AdminRoleRelation;
import com.meituan.waimai.model.AdminUser;
import com.meituan.waimai.model.Role;
import com.meituan.waimai.service.AdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Api(tags = "后台用户管理")
@RestController("/admin")
@Slf4j
public class AdminController {

    @Value("${jwt.tokenHeader}")
    private String tokenHeader;
    @Value("${jwt.tokenHead}")
    private String tokenHead;

    @Autowired
    private AdminService adminService;


    @ApiOperation(value = "登录以后返回token")
    @PostMapping(value = "/login")
    public CommonResult login(@Validated @RequestBody AdminLoginParam adminLoginParam)  {
        String token = adminService.login(adminLoginParam.getUsername(), adminLoginParam.getPassword());
        if (token == null) {
            return CommonResult.validateFailed("用户名或密码错误");
        }
        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token", token);
        tokenMap.put("tokenHead", tokenHead);
        return CommonResult.success(tokenMap);
    }

    @ApiOperation(value = "登出")
    @PostMapping(value = "/logout")
    public CommonResult logout() {
        return CommonResult.success(null);
    }

    @ApiOperation("获取当前登录用户信息")
    @GetMapping(value = "/info")
    public CommonResult getAdminInfo(Principal principal) {
        if(principal==null){
            return CommonResult.unauthorized(null);
        }
        String username = principal.getName();
        AdminUser admin = adminService.getAdminByUsername(username);
        Map<String,Object> data= new HashMap<>();
        data.put("username",admin.getUsername());
        data.put("menus",adminService.getRoleMenuByAdminId(admin.getId()));
        List<Role> roleList=adminService.getRoleList(admin.getId());
        if(CollUtil.isNotEmpty(roleList)){
            List<String> roles = roleList.stream().map(Role::getName).collect(Collectors.toList());
            data.put("roles",roles);
        }

        return CommonResult.success(data);
    }

    @ApiOperation(value = "用户列表")
    @GetMapping(value = "/list")
    public CommonResult<CommonPage<AdminUser>> list(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                                @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                String keyword) {
        List<AdminUser> list = adminService.list(pageNum, pageSize, keyword);
        return CommonResult.success(CommonPage.restPage(list));
    }

    @ApiOperation(value = "创建新用户")
    @PutMapping(value = "/create")
    public CommonResult create(@RequestBody AdminUser admin) {
        return  adminService.create(admin)? CommonResult.success(): CommonResult.failed();
    }

    @ApiOperation(value = "修改用户信息")
    @PostMapping(value = "/update")
    public CommonResult update(@RequestBody AdminUser admin) {
        return  adminService.updateById(admin)? CommonResult.success(): CommonResult.failed();
    }

    @ApiOperation(value = "修改用户状态")
    @PostMapping(value = "/updateStatus")
    public CommonResult updateStatus(@RequestParam("id")Integer id, @RequestParam("status")Integer status) {
        AdminUser admin = new AdminUser();
        admin.setStatus(status);
        admin.setId(id);
        return  adminService.updateById(admin)? CommonResult.success(): CommonResult.failed();
    }

    @ApiOperation("获取用户信息")
    @GetMapping(value = "/{id}")
    public CommonResult<AdminUser> getItem(@PathVariable Integer id) {
        return CommonResult.success(adminService.getById(id));
    }


    @ApiOperation("设置角色")
    @PostMapping(value = "/allotRole")
    public CommonResult allotRole(@RequestParam Integer adminId,@RequestParam List<Integer> roleIds) {
        int count = adminService.allotRole(adminId,roleIds);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("获取用户角色")
    @GetMapping(value = "/role/{id}")
    public CommonResult<List<AdminRoleRelation>> getRole(@PathVariable Integer id) {
        List<AdminRoleRelation> list = adminService.getRole(id);
        return CommonResult.success(list);
    }
}
