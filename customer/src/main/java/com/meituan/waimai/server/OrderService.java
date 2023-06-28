package com.meituan.waimai.server;


import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.DesensitizedUtil;
import cn.hutool.core.util.NumberUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.collect.ImmutableBiMap;
import com.google.common.collect.Lists;
import com.meituan.waimai.bean.CustomerContext;
import com.meituan.waimai.bean.GeoPoint;
import com.meituan.waimai.common.util.DistanceCalculator;
import com.meituan.waimai.mapper.*;
import com.meituan.waimai.model.*;
import com.meituan.waimai.model.vo.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.meituan.waimai.model.dto.OrderPreViewParams.FoodSpec;
import com.meituan.waimai.model.vo.OrderDetail.*;


@Slf4j
@Service
public class OrderService extends ServiceImpl<OrderMapper, Order> {

    @Autowired
    ShopMapper shopMapper;
    @Autowired
    CustomerAddressService addressService;
    @Autowired
    ProductMapper productMapper;
    @Autowired
    ActivityService activityService;
    @Autowired
    CouponMapper couponMapper;
    @Autowired
    CouponHistoryMapper couponHistoryMapper;

    public OrderDetail preViewOrder(@NotNull Integer shopId, @NotNull List<FoodSpec> foodList) {

        OrderDetail orderDetail = new OrderDetail();

        Shop shop = shopMapper.selectById(shopId);
        if (shop != null) {
            orderDetail.setImageUrl(shop.getPicUrl());
            orderDetail.setExclusiveDelivery(shop.getExclusiveDelivery());
            orderDetail.setShopName(shop.getShopName());
        }

        GeoPoint customerPoint = CustomerContext.getKeyLocation();
        if (customerPoint != null && shop != null && shop.getLocation() != null) {

            GeoPoint shopPoint = shop.getLocation();
            double meter = DistanceCalculator.calculateDistance(customerPoint.getLat(), customerPoint.getLng(), shopPoint.getLat(), shopPoint.getLng());

            LambdaQueryWrapper<CustomerAddress> queryWrapper = new LambdaQueryWrapper<>();
            queryWrapper.eq(CustomerAddress::getLocation, customerPoint);
            queryWrapper.eq(CustomerAddress::getCustomerId, CustomerContext.getCustomerId());
            CustomerAddress customerAddress = addressService.getOne(queryWrapper);

            if (meter < 10000 && customerAddress != null) {
                AddressInfo addressInfo = new AddressInfo();
                addressInfo.setAddress(customerAddress.getShippingAddress());
                addressInfo.setGender(customerAddress.getGender().equals(1) ? "先生" : "女士");
                addressInfo.setId(customerAddress.getId());
                addressInfo.setName(customerAddress.getName());
                addressInfo.setPhone(customerAddress.getPhone());
                orderDetail.setAddressInfo(addressInfo);
            }
        }

        List<Cart> shoppingCartList = Lists.newArrayList();
        double boxFeeTotal = 0.0;
        double amount = 0.0;
        for (FoodSpec foodSpec : foodList) {
            Product product = productMapper.selectById(foodSpec.getFoodId());
            if (product != null) {
                Double boxFee = product.getBoxFee();
                if (boxFee != null) {
                    boxFeeTotal = boxFeeTotal + boxFee;
                }
                Cart shoppingCart = new Cart();
                shoppingCart.setCount(foodSpec.getCount());
                shoppingCart.setFoodId(product.getId());
                shoppingCart.setFoodImage(product.getImageUrl());
                shoppingCart.setFoodName(product.getName());
                if (product.getUnit() != null) {
                    if (product.getUnit() == 1) {
                        shoppingCart.setUnit(String.format("约%s克", product.getWeight()));
                    } else {
                        shoppingCart.setUnit(String.format("%s人份", product.getWeight()));
                    }
                }
                ActivityService.DiscountPrice discountPrice = activityService.getDiscountPrice(shopId, foodSpec.getFoodId(), foodSpec.getCount(), product.getPrice());
                if (discountPrice == null) {
                    BigDecimal count = new BigDecimal(foodSpec.getCount());
                    BigDecimal price = BigDecimal.valueOf(product.getPrice());
                    shoppingCart.setCurrentAmount(price.multiply(count).doubleValue());
                    amount = NumberUtil.add(amount,shoppingCart.getCurrentAmount().doubleValue());
                } else {
                    shoppingCart.setCurrentAmount(discountPrice.getCurrentPrice());
                    shoppingCart.setOriginAmount(discountPrice.getOriginPrice());
                    amount = NumberUtil.add(amount,discountPrice.getOriginPrice().doubleValue());
                }
                shoppingCartList.add(shoppingCart);
            }
        }
        orderDetail.setAmount(amount);
        orderDetail.setBoxFee(boxFeeTotal);
        orderDetail.setFoodList(shoppingCartList);
        orderDetail.setDeliverFee(5.0);
        orderDetail.setDeliverTime(DateUtil.offsetHour(DateUtil.date(),1).getTime());

        LambdaQueryWrapper<CouponHistory> couponHistoryQueryWrapper = new LambdaQueryWrapper<>();
        couponHistoryQueryWrapper.eq(CouponHistory::getCustomerId, CustomerContext.getCustomerId());
        couponHistoryQueryWrapper.ge(CouponHistory::getEndTime, new Date());
        List<CouponHistory> couponHistories = couponHistoryMapper.selectList(couponHistoryQueryWrapper);


        CouponDetailVo validCoupon = new CouponDetailVo();
        validCoupon.setCouponValid(1);
        validCoupon.setCouponInfoList(Lists.newArrayList());

        CouponDetailVo invalidCoupon = new CouponDetailVo();
        invalidCoupon.setCouponValid(0);
        invalidCoupon.setCouponInfoList(Lists.newArrayList());


        couponHistories.forEach(couponHistory -> {
            Coupon coupon = couponMapper.selectById(couponHistory.getCouponId());

            CouponInfo couponInfo = new CouponInfo();
            couponInfo.setId(couponHistory.getId());
            couponInfo.setCouponId(couponInfo.getId());
            couponInfo.setAmount(coupon.getAmount());
            couponInfo.setTitle(coupon.getName());
            couponInfo.setPriceLimit(String.format("满%s可用",coupon.getLimitPrice()));
            if(DateUtil.between(DateUtil.date(),couponHistory.getEndTime(), DateUnit.DAY) == 0L){
                couponInfo.setPriceLimit("今日到期");
            }else{
                couponInfo.setPriceLimit(String.format("有效期至%s",DateUtil.format(couponHistory.getEndTime(),"yyyy-MM-dd")));
            }
            if(coupon.getIncludeSelfPhone() != null && coupon.getIncludeSelfPhone()){
                couponInfo.setUseLimits(StrUtil.format(coupon.getNote(),ImmutableBiMap.of("phone", DesensitizedUtil.mobilePhone(CustomerContext.getKeyCustomerTelephone()))));
            }else {
                couponInfo.setUseLimits(coupon.getNote());
            }

            double total;
            if(coupon.getIncludeDiscount() != null && coupon.getIncludeDiscount()){
                total = orderDetail.getAmount();
            }else {
                total = orderDetail.getFoodList().stream().mapToDouble(Cart::getCurrentAmount).sum();
            }
            if(coupon.getIncludeBoxFee() != null && coupon.getIncludeBoxFee()){
                total = NumberUtil.add(total, orderDetail.getBoxFee().doubleValue());
            }
            if(coupon.getIncludeDeliverFee() != null && coupon.getIncludeDeliverFee()){
                total = NumberUtil.add(total, orderDetail.getDeliverFee().doubleValue());
            }
            if(total >= coupon.getLimitPrice()){
                validCoupon.getCouponInfoList().add(couponInfo);
            }else {
                invalidCoupon.getCouponInfoList().add(couponInfo);
            }
        });
        orderDetail.setCouponDetailVos(Arrays.asList(validCoupon,invalidCoupon));
        return orderDetail;
    }
}
