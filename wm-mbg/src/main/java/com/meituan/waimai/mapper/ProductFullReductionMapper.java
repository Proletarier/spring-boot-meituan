package com.meituan.waimai.mapper;

import com.meituan.waimai.model.ProductFullReduction;
import com.meituan.waimai.model.ProductFullReductionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProductFullReductionMapper {
    long countByExample(ProductFullReductionExample example);

    int deleteByExample(ProductFullReductionExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ProductFullReduction record);

    int insertSelective(ProductFullReduction record);

    List<ProductFullReduction> selectByExample(ProductFullReductionExample example);

    ProductFullReduction selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ProductFullReduction record, @Param("example") ProductFullReductionExample example);

    int updateByExample(@Param("record") ProductFullReduction record, @Param("example") ProductFullReductionExample example);

    int updateByPrimaryKeySelective(ProductFullReduction record);

    int updateByPrimaryKey(ProductFullReduction record);
}