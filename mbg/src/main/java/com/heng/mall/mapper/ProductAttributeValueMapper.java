package com.heng.mall.mapper;

import com.heng.mall.model.ProductAttributeValue;
import com.heng.mall.model.ProductAttributeValueExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProductAttributeValueMapper {
    long countByExample(ProductAttributeValueExample example);

    int deleteByExample(ProductAttributeValueExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ProductAttributeValue record);

    int insertSelective(ProductAttributeValue record);

    List<ProductAttributeValue> selectByExample(ProductAttributeValueExample example);

    ProductAttributeValue selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ProductAttributeValue record, @Param("example") ProductAttributeValueExample example);

    int updateByExample(@Param("record") ProductAttributeValue record, @Param("example") ProductAttributeValueExample example);

    int updateByPrimaryKeySelective(ProductAttributeValue record);

    int updateByPrimaryKey(ProductAttributeValue record);
}