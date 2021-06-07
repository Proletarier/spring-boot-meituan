package com.heng.mall.mapper;

import com.heng.mall.model.ShopPromotionDetails;
import com.heng.mall.model.ShopPromotionDetailsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ShopPromotionDetailsMapper {
    long countByExample(ShopPromotionDetailsExample example);

    int deleteByExample(ShopPromotionDetailsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ShopPromotionDetails record);

    int insertSelective(ShopPromotionDetails record);

    List<ShopPromotionDetails> selectByExample(ShopPromotionDetailsExample example);

    ShopPromotionDetails selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ShopPromotionDetails record, @Param("example") ShopPromotionDetailsExample example);

    int updateByExample(@Param("record") ShopPromotionDetails record, @Param("example") ShopPromotionDetailsExample example);

    int updateByPrimaryKeySelective(ShopPromotionDetails record);

    int updateByPrimaryKey(ShopPromotionDetails record);
}