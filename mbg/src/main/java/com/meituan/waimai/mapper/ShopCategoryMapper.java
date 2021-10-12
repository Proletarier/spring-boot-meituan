package com.meituan.waimai.mapper;

import com.meituan.waimai.model.ShopCategoryExample;
import com.meituan.waimai.model.ShopCategory;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface ShopCategoryMapper {
    long countByExample(ShopCategoryExample example);

    int deleteByExample(ShopCategoryExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ShopCategory record);

    int insertSelective(ShopCategory record);

    List<ShopCategory> selectByExample(ShopCategoryExample example);

    ShopCategory selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ShopCategory record, @Param("example") ShopCategoryExample example);

    int updateByExample(@Param("record") ShopCategory record, @Param("example") ShopCategoryExample example);

    int updateByPrimaryKeySelective(ShopCategory record);

    int updateByPrimaryKey(ShopCategory record);
}