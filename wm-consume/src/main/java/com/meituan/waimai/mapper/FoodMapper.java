package com.meituan.waimai.mapper;

import com.meituan.waimai.handler.StringArrayListTypeHandler;
import com.meituan.waimai.model.Product;
import com.meituan.waimai.model.vo.Food;
import com.meituan.waimai.model.vo.FoodAttribute;
import com.meituan.waimai.model.vo.FoodAttributeValue;
import org.apache.ibatis.annotations.*;

import java.util.ArrayList;
import java.util.List;


@Mapper
public interface FoodMapper {


    @Select({
            "<script>",
            "select p.id as foodId,mpr.menu_id as menuId,p.name as spuName, CONCAT(p.weight, '克') as unit,",
            "p.image_url as imageUrl,p.introduce as spuDesc,p.price as originPrice, p.tag,",
            "p.box_fee as boxFee, p.sale->'$.praise_num' as praiseNum,",
            " p.sale->'$.sell_month_count' as saleVolume,p.must",
            "from _product p,_menu_product_relation mpr",
            "where p.id = mpr.product_id and p.sell_status = 0",
            "and mpr.menu_id in",
            "<foreach item='menuId' index='index' collection='menuIds' open='(' separator=',' close=')'>",
            "#{menuId}",
            "</foreach>",
            "</script>"
    })
    @Results({
            @Result(column = "tag", property = "labelList", javaType = ArrayList.class, typeHandler = StringArrayListTypeHandler.class),
    })
    List<Food> selectProductByMenuId(@Param("menuIds") List<Integer> menuIds);


    @Select({
            "<script>",
            "select",
            "distinct pac.category_name,pav.product_id,pav.product_attribute_category_id ",
            "from `_product_attribute_value` pav",
            "left join  `_product_attribute_category` pac on pav.product_attribute_category_id   = pac.id ",
            "where  pav.product_id = #{productId}",
            "</script>"
    })
    @Results({
            @Result(column = "category_name", property = "attributeName"),
            @Result(column = "{productId = product_id,categoryId=product_attribute_category_id}", property = "spuAttrValueList",
                    many = @Many(select = "com.meituan.waimai.mapper.FoodMapper.getFoodAttributeValueByProductIdAndCateId")),
    })
    List<FoodAttribute> selectFoodAttribute(@Param("productId") Integer productId);


    @Select({
            "select",
            "pa.name as attrValue ,pa.id as attrId",
            "from",
            "`_product_attribute_value` pav",
            "left join `_product_attribute` pa  on  pav.product_attribute_id  = pa.id",
            "where  pav.product_id = #{productId} and pav.product_attribute_category_id  = #{categoryId} ",
    })
    List<FoodAttributeValue> getFoodAttributeValueByProductIdAndCateId(@Param("productId") Long productId, @Param("categoryId") Long categoryId);

}
