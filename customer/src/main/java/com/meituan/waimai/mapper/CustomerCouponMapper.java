package com.meituan.waimai.mapper;


import org.apache.ibatis.annotations.*;
@Mapper
public interface CustomerCouponMapper {

    @Select({
            "<script>",
            "select amount from _coupon c,_coupon_history ch where ch.coupon_id = #{couponId} and ",
            "</script>"
    })
    double getCouponPrice(@Param("couponId") Integer couponId,@Param("customerCouponId") Integer customerCouponId);

}
