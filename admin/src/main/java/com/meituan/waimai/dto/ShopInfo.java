package com.meituan.waimai.dto;


import com.meituan.waimai.model.Shop;
import com.meituan.waimai.model.ShopPromotionDetails;
import com.meituan.waimai.model.ShopQualification;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
public class ShopInfo extends Shop {

    @ApiModelProperty("店铺活动明细")
    private List<ShopPromotionDetails> shopPromotionDetails;
    @ApiModelProperty("资格证书")
    private ShopQualification shopQualification;
}
