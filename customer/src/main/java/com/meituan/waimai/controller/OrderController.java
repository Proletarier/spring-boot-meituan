package com.meituan.waimai.controller;


import com.meituan.waimai.common.domain.CommonResult;
import com.meituan.waimai.model.dto.OrderPreViewParams;
import com.meituan.waimai.model.vo.OrderDetail;
import com.meituan.waimai.server.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/api/order")
public class OrderController {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    OrderService orderService;

    @PostMapping(value = "/preview")
    public CommonResult<OrderDetail> previewOrder(@RequestBody @Validated OrderPreViewParams orderPreViewParams) {
        return CommonResult.success(orderService.preViewOrder(orderPreViewParams.getShopId(),orderPreViewParams.getFoodList(),orderPreViewParams.getCustomerCouponId()));
    }

}
