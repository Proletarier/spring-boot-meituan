package com.heng.mall.mapper;

import com.heng.mall.model.ProductCategoryRelation;
import com.heng.mall.model.ProductCategoryRelationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProductCategoryRelationMapper {
    long countByExample(ProductCategoryRelationExample example);

    int deleteByExample(ProductCategoryRelationExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ProductCategoryRelation record);

    int insertSelective(ProductCategoryRelation record);

    List<ProductCategoryRelation> selectByExample(ProductCategoryRelationExample example);

    ProductCategoryRelation selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ProductCategoryRelation record, @Param("example") ProductCategoryRelationExample example);

    int updateByExample(@Param("record") ProductCategoryRelation record, @Param("example") ProductCategoryRelationExample example);

    int updateByPrimaryKeySelective(ProductCategoryRelation record);

    int updateByPrimaryKey(ProductCategoryRelation record);
}