package com.meituan.waimai.mapper;

import com.meituan.waimai.model.ProductSkuStock;
import com.meituan.waimai.model.ProductSkuStockExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProductSkuStockMapper {
    long countByExample(ProductSkuStockExample example);

    int deleteByExample(ProductSkuStockExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ProductSkuStock record);

    int insertSelective(ProductSkuStock record);

    List<ProductSkuStock> selectByExample(ProductSkuStockExample example);

    ProductSkuStock selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ProductSkuStock record, @Param("example") ProductSkuStockExample example);

    int updateByExample(@Param("record") ProductSkuStock record, @Param("example") ProductSkuStockExample example);

    int updateByPrimaryKeySelective(ProductSkuStock record);

    int updateByPrimaryKey(ProductSkuStock record);
}