package com.meituan.waimai.mapper;


import com.meituan.waimai.model.dto.ShopSearch;
import com.meituan.waimai.model.vo.ShopVo;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface NearShopMapper {

    @Select({
            "<script>",
            "select shop_name as shopName,",
            "pic_url as picUrl,",
            "location as distance,",
            "sale->'$.shopScore' as shopScore,",
            "sale->'$.monthSales' as monthSalesTip,",
            "basics_fee->'$.minPrice' as minPriceTip,",
            "basics_fee->'$.shippingFee' as shippingFeeTip,",
            "basics_fee->'$.averagePrice' as averagePriceTip,",
            "from _shop",
            "limit #{limit} offset #{offset}",
            "</script>"
    })
    List<ShopVo> selectNearShopMapper(ShopSearch shopSearch, @Param("offSet") int offSet);
}
