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
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.meituan.waimai.model.dto.OrderPreViewParams.FoodSpec;
import com.meituan.waimai.model.vo.OrderDetail.*;

import static com.meituan.waimai.enums.CouponEnum.CouponTypeEnum.*;


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
    @Autowired
    CouponShopRelationMapper couponShopRelationMapper;
    @Autowired
    CouponShopCategoryRelationMapper couponShopCategoryRelationMapper;

    private static final int part = 0;
    private static final int gram = 1;


    public OrderDetail preViewOrder(@NotNull Integer shopId, @NotNull List<FoodSpec> foodList, Integer couponId) {
        OrderDetail orderDetail = new OrderDetail();
        // set shop info
        Shop shop = shopMapper.selectById(shopId);
        orderDetail.setImageUrl(shop.getPicUrl());
        orderDetail.setExclusiveDelivery(shop.getExclusiveDelivery());
        orderDetail.setShopName(shop.getShopName());
        // set address
        AddressInfo addressInfo = getAddress(shop.getLocation());
        orderDetail.setAddressInfo(addressInfo);
        // set cart
        List<Cart> cartList = getShopCartInfo(foodList, shopId);
        orderDetail.setFoodList(cartList);
        // set box price
        double boxFeeTotal = cartList.stream().mapToDouble(Cart::getBoxPrice).sum();
        orderDetail.setBoxFee(boxFeeTotal);
        // set deliver price
        orderDetail.setDeliverFee(5.0);
        orderDetail.setDeliverTime(DateUtil.offsetHour(DateUtil.date(), 1).getTime());
        //set coupon
        setCouponList(orderDetail, shopId, shop.getCategoryId());
        // set coupon price
        if (couponId != null) {
            orderDetail.getCouponDetailVos().forEach(couponDetailVo -> {
                if (couponDetailVo.getCouponValid() == 1) {
                    CouponInfo coupon = couponDetailVo.getCouponInfoList().stream().filter(couponInfo -> couponInfo.getId().equals(couponId)).findFirst().orElse(null);
                    if (coupon != null) {
                        orderDetail.setCouponId(couponId);
                        orderDetail.setCouponPrice(coupon.getAmount());
                    }
                }
            });
        }
        // set discount price
        double totalPrice = cartList.stream().mapToDouble(cart -> cart.getOriginAmount() == null ? cart.getCurrentAmount() : cart.getOriginAmount()).sum();
        double discountedPrice = cartList.stream().mapToDouble(Cart::getCurrentAmount).sum();
        double discountPrice = NumberUtil.sub(totalPrice, discountedPrice);
        if (orderDetail.getCouponPrice() != null) {
            orderDetail.setTotalDiscountPrice(NumberUtil.add(discountPrice, orderDetail.getCouponPrice().doubleValue()));
        } else {
            orderDetail.setTotalDiscountPrice(discountPrice);
        }
        // set total price
        double payPrice = discountedPrice;
        if (orderDetail.getCouponPrice() != null) {
            payPrice =  NumberUtil.sub(payPrice, orderDetail.getCouponPrice().doubleValue());
        }
        if(orderDetail.getDeliverFee() != null){
            payPrice = NumberUtil.add(payPrice, orderDetail.getDeliverFee().doubleValue());
        }
        if(orderDetail.getBoxFee() != null){
            payPrice = NumberUtil.add(payPrice, orderDetail.getBoxFee().doubleValue());
        }
        orderDetail.setTotalPrice(payPrice);
        return orderDetail;
    }


    private void setCouponList(OrderDetail orderDetail, Integer shopId, String categoryId) {
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
            couponInfo.setCouponType(couponInfo.getCouponType());
            couponInfo.setCouponId(couponInfo.getId());
            couponInfo.setAmount(coupon.getAmount());
            couponInfo.setTitle(coupon.getName());
            couponInfo.setPriceLimit(String.format("满%s可用", new DecimalFormat("#").format(coupon.getLimitPrice())));
            if (DateUtil.between(DateUtil.date(), couponHistory.getEndTime(), DateUnit.DAY) == 0L) {
                couponInfo.setTimeLimit("今日到期");
            } else {
                couponInfo.setTimeLimit(String.format("有效期至%s", DateUtil.format(couponHistory.getEndTime(), "yyyy-MM-dd")));
            }
            if (coupon.getIncludeSelfPhone() != null && coupon.getIncludeSelfPhone()) {
                couponInfo.setUseLimits(StrUtil.format(coupon.getNote(), ImmutableBiMap.of("phone", DesensitizedUtil.mobilePhone(CustomerContext.getKeyCustomerTelephone()))));
            } else {
                couponInfo.setUseLimits(coupon.getNote());
            }

            if (MEMBER_BUY.getValue() == coupon.getType()) {
                validCoupon.getCouponInfoList().add(couponInfo);
            } else {
                double total;
                if (coupon.getIncludeDiscount() != null && coupon.getIncludeDiscount()) {
                    total = orderDetail.getFoodList().stream().mapToDouble(cart -> cart.getOriginAmount() == null ? cart.getCurrentAmount() : cart.getOriginAmount()).sum();
                } else {
                    total = orderDetail.getFoodList().stream().mapToDouble(Cart::getCurrentAmount).sum();
                }
                if (coupon.getIncludeBoxFee() != null && coupon.getIncludeBoxFee()) {
                    total = NumberUtil.add(total, orderDetail.getBoxFee().doubleValue());
                }
                if (coupon.getIncludeDeliverFee() != null && coupon.getIncludeDeliverFee()) {
                    total = NumberUtil.add(total, orderDetail.getDeliverFee().doubleValue());
                }

                boolean isValid = true;
                if (PART.getValue() == coupon.getType()) {
                    LambdaQueryWrapper<CouponShopRelation> couponShopRelationLambdaQueryWrapper = new LambdaQueryWrapper<>();
                    couponShopRelationLambdaQueryWrapper.eq(CouponShopRelation::getCouponId, coupon.getId());
                    couponShopRelationLambdaQueryWrapper.eq(CouponShopRelation::getShopId, shopId);
                    CouponShopRelation couponShopRelation = couponShopRelationMapper.selectOne(couponShopRelationLambdaQueryWrapper);
                    isValid = couponShopRelation != null;
                } else if (SHOP_TYPE.getValue() == coupon.getType()) {
                    if (categoryId == null) {
                        isValid = false;
                    } else {
                        List<Integer> cateIds = Lists.newArrayList();
                        for (String cateId : categoryId.split(",")) {
                            cateIds.add(Integer.parseInt(cateId));
                        }
                        LambdaQueryWrapper<CouponShopCategoryRelation> couponShopCategoryRelationLambdaQueryWrapper = new LambdaQueryWrapper<>();
                        couponShopCategoryRelationLambdaQueryWrapper.eq(CouponShopCategoryRelation::getCouponId, coupon.getId());
                        couponShopCategoryRelationLambdaQueryWrapper.in(CouponShopCategoryRelation::getShopCategoryId, cateIds);
                        CouponShopCategoryRelation couponShopRelation = couponShopCategoryRelationMapper.selectOne(couponShopCategoryRelationLambdaQueryWrapper);
                        isValid = couponShopRelation != null;
                    }
                }
                if (isValid) {
                    if (total >= coupon.getLimitPrice()) {
                        validCoupon.getCouponInfoList().add(couponInfo);
                    } else {
                        invalidCoupon.getCouponInfoList().add(couponInfo);
                    }
                } else {
                    invalidCoupon.getCouponInfoList().add(couponInfo);
                }
            }
        });

        orderDetail.setCouponDetailVos(Arrays.asList(validCoupon, invalidCoupon));
    }

    private AddressInfo getAddress(GeoPoint shopPoint) {

        GeoPoint customerPoint = CustomerContext.getKeyLocation();
        if (customerPoint != null && shopPoint != null) {
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
                return addressInfo;
            }
        }
        return null;
    }

    private List<Cart> getShopCartInfo(List<FoodSpec> foodList, Integer shopId) {

        List<Cart> shoppingCartList = Lists.newArrayList();

        for (FoodSpec foodSpec : foodList) {
            Product product = productMapper.selectById(foodSpec.getFoodId());
            if (product != null) {
                Cart shoppingCart = new Cart();
                shoppingCart.setCount(foodSpec.getCount());
                shoppingCart.setFoodId(product.getId());
                shoppingCart.setFoodImage(product.getImageUrl());
                shoppingCart.setFoodName(product.getName());
                shoppingCart.setBoxPrice(NumberUtil.mul(product.getBoxFee(),foodSpec.getCount()).doubleValue());
                if (product.getUnit() != null) {
                    if (product.getUnit() == gram && product.getWeight() != null) {
                        shoppingCart.setUnit(String.format("约%s克", product.getWeight()));
                    } else if (product.getUnit() == part && product.getWeight() != null) {
                        shoppingCart.setUnit(String.format("%s人份", product.getWeight()));
                    }
                }
                ActivityService.DiscountPrice discountPrice = activityService.getDiscountPrice(shopId, foodSpec.getFoodId(), foodSpec.getCount(), product.getPrice());
                if (discountPrice == null) {
                    BigDecimal count = new BigDecimal(foodSpec.getCount());
                    BigDecimal price = BigDecimal.valueOf(product.getPrice());
                    shoppingCart.setCurrentAmount(price.multiply(count).doubleValue());
                } else {
                    shoppingCart.setCurrentAmount(discountPrice.getCurrentPrice());
                    shoppingCart.setOriginAmount(discountPrice.getOriginPrice());
                }
                shoppingCartList.add(shoppingCart);
            }
        }
        return shoppingCartList;
    }

}
