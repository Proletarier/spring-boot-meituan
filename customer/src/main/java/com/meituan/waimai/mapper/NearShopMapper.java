package com.meituan.waimai.mapper;


import com.meituan.waimai.model.dto.ShopFilter;
import com.meituan.waimai.model.vo.NearShops;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface NearShopMapper {

    @Select({
            "<script>",
            "select id,shop_name as shopName,",
            "pic_url as picUrl,",
            "ST_DISTANCE_SPHERE(location, POINT(#{condition.location.lat},#{condition.location.lng})) as distance,",
            "sale->'$.score.shopScore' as shopScore,",
            "sale->'$.score.qualityScore' as qualityScore,",
            "sale->'$.score.deliveryScore' as deliveryScore,",
            "sale->'$.monthSales' as monthSalesTip,",
            "sale->'$.minPrice' as minPriceTip,",
            "sale->'$.shippingFee' as shippingFeeTip,",
            "sale->'$.averagePrice' as averagePriceTip",
            "from _shop  where 1=1",
            "<if test='condition.exclusiveDelivery == true'>",
            "and exclusive_delivery = true",
            "</if>",
            "<if test='condition.feature != null and condition.feature.size() > 0'>",
            "and characteristics in",
            "<foreach item='feature' index='index' collection='condition.features' open='(' separator=',' close=')'>",
            "#{feature}",
            "</foreach>",
            "</if>",
            "<if test='condition.averagePrice != null'>",
            "and exclusive_delivery = true",
            "</if>",
            "<if test='cateIds != null and cateIds.size() > 0'>",
            "and ",
            "<foreach item='categoryId' index='index' collection='cateIds' open='(' separator='or' close=')'>",
            " find_in_set(#{categoryId},category_id) ",
            "</foreach>",
            "</if>",
            "<if test='condition.ruleSort != null'>",
            "<choose>",
            "<when test='condition.ruleSort.toString() == &apos;score&apos;'>",
            "order by shopScore desc ",
            "</when>",
            "<when test='condition.ruleSort.toString() == &apos;speed&apos;'>",
            "order by deliveryScore desc ",
            "</when>",
            "<when test='condition.ruleSort.toString() == &apos;sales&apos;'>",
            "order by monthSalesTip desc ",
            "</when>",
            "<when test='condition.ruleSort.toString() == &apos;distance&apos;'>",
            "order by distance asc ",
            "</when>",
            "<when test='condition.ruleSort.toString() == &apos;min_shipping_fee&apos;'>",
            "order by shippingFeeTip asc ",
            "</when>",
            "<when test='condition.ruleSort.toString() == &apos;min_price&apos;'>",
            "order by minPriceTip asc ",
            "</when>",
            "<when test='condition.ruleSort.toString() == &apos;min_average_price&apos;'>",
            "order by averagePriceTip asc ",
            "</when>",
            "<when test='condition.ruleSort.toString() == &apos;max_average_price&apos;'>",
            "order by averagePriceTip desc ",
            "</when>",
            "<otherwise>",
            "order by shopScore,qualityScore desc ",
            "</otherwise>",
            "</choose>",
            "</if>",
            "limit #{condition.limit} offset #{offset}",
            "</script>"
    })
    List<NearShops.ShopProfile> selectNearShopMapper(@Param("condition") ShopFilter shopFilter,
                                                     @Param("cateIds") List<Integer> cateIds,
                                                     @Param("offset") int offSet);


    @Select({
            "<script>",
            "select count(*) ",
            "from _shop  where 1=1",
            "<if test='condition.exclusiveDelivery == true'>",
            "and exclusive_delivery = true",
            "</if>",
            "<if test='condition.feature != null and condition.feature.size() > 0'>",
            "and characteristics in",
            "<foreach item='feature' index='index' collection='condition.features' open='(' separator=',' close=')'>",
            "#{feature}",
            "</foreach>",
            "</if>",
            "<if test='condition.averagePrice != null'>",
            "and exclusive_delivery = true",
            "</if>",
            "<if test='cateIds != null and cateIds.size() > 0'>",
            "and ",
            "<foreach item='categoryId' index='index' collection='cateIds' open='(' separator='or' close=')'>",
            " find_in_set(#{categoryId},category_id) ",
            "</foreach>",
            "</if>",
            "</script>"
    })
    int countNearShopMapper(@Param("condition") ShopFilter shopFilter, @Param("cateIds") List<Integer> cateIds);



}
