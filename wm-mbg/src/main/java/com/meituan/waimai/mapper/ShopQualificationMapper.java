package com.meituan.waimai.mapper;

import com.meituan.waimai.model.ShopQualification;
import com.meituan.waimai.model.ShopQualificationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ShopQualificationMapper {
    long countByExample(ShopQualificationExample example);

    int deleteByExample(ShopQualificationExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ShopQualification record);

    int insertSelective(ShopQualification record);

    List<ShopQualification> selectByExample(ShopQualificationExample example);

    ShopQualification selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ShopQualification record, @Param("example") ShopQualificationExample example);

    int updateByExample(@Param("record") ShopQualification record, @Param("example") ShopQualificationExample example);

    int updateByPrimaryKeySelective(ShopQualification record);

    int updateByPrimaryKey(ShopQualification record);
}