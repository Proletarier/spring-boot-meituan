package com.meituan.waimai.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

public interface CouponEnum {

    int getValue();

    @Getter
    @AllArgsConstructor
    enum CouponTypeEnum implements CouponEnum {
        ALL(0), PART(1), SHOP_TYPE(2), MEMBER_BUY(3);

        private final int value;
    }

}
