package com.meituan.waimai.mapper;


import com.meituan.waimai.model.dto.ShopFilter;
import com.meituan.waimai.model.vo.ShopVo;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface NearShopMapper {

    @Select({
            "<script>",
            "select id,shop_name as shopName,",
            "pic_url as picUrl,",
            "ST_DISTANCE_SPHERE(location, POINT(SUBSTRING_INDEX(#{condition.location},',',1),SUBSTRING_INDEX(#{condition.location},',',-1))) as distance,",
            "sale->'$.score.shopScore' as shopScore,",
            "sale->'$.score.qualityScore' as qualityScore,",
            "sale->'$.score.deliveryScore' as deliveryScore,",
            "sale->'$.monthSales' as monthSalesTip,",
            "sale->'$.minPrice' as minPriceTip,",
            "sale->'$.shippingFee' as shippingFeeTip,",
            "sale->'$.averagePrice' as averagePriceTip",
            "from _shop",
            "<choose>",
                "<when test='condition.ruleSort == &apos;score&apos;'>",
                    "order by shopScore desc ",
                "</when>",
                "<when test='condition.ruleSort == &apos;speed&apos;'>",
                    "order by deliveryScore desc ",
                "</when>",
                "<when test='condition.ruleSort == &apos;min_shipping_fee&apos;'>",
                     "order by monthSalesTip desc ",
                 "</when>",
                "<when test='condition.ruleSort == &apos;min_price&apos;'>",
                    "order by minPriceTip desc ",
                "</when>",
                "<when test='condition.ruleSort == &apos;min_average_price&apos;'>",
                    "order by averagePriceTip asc ",
                    "</when>",
                "<when test='condition.ruleSort == &apos;max_average_price&apos;'>",
                    "order by averagePriceTip desc ",
                "</when>",
                "<otherwise>",
                    "order by shopScore,qualityScore desc ",
                "</otherwise>",
            "</choose>",
            "<if test='condition.salesSort != null and condition.distanceSort != null'>",
            "<choose>",
                "<when test='condition.salesSort != null'>",
                    ",monthSalesTip desc ",
                "</when>",
                "<otherwise>",
                    ",distance asc ",
                "</otherwise>",
            "</choose>",
            "</if>",
            "limit #{condition.limit} offset #{offset}",
            "</script>"
    })
    List<ShopVo> selectNearShopMapper (@Param("condition") ShopFilter shopFilter, @Param("offset") int offSet);
}
