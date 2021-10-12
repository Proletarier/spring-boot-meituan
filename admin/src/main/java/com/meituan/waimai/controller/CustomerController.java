package com.meituan.waimai.controller;


import com.meituan.waimai.common.api.CommonPage;
import com.meituan.waimai.common.api.CommonResult;
import com.heng.mall.model.Customer;
import com.meituan.waimai.service.CustomerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "用户")
@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;


    @ApiOperation("用户list")
    @GetMapping("list")
    public CommonResult<CommonPage<Customer>> list(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                                   @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        List<Customer> customerList = customerService.list(pageNum, pageSize);
        return CommonResult.success(CommonPage.restPage(customerList));
    }
}
