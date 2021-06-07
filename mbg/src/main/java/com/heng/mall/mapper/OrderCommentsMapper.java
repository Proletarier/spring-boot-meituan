package com.heng.mall.mapper;

import com.heng.mall.model.OrderComments;
import com.heng.mall.model.OrderCommentsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderCommentsMapper {
    long countByExample(OrderCommentsExample example);

    int deleteByExample(OrderCommentsExample example);

    int deleteByPrimaryKey(Long id);

    int insert(OrderComments record);

    int insertSelective(OrderComments record);

    List<OrderComments> selectByExample(OrderCommentsExample example);

    OrderComments selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") OrderComments record, @Param("example") OrderCommentsExample example);

    int updateByExample(@Param("record") OrderComments record, @Param("example") OrderCommentsExample example);

    int updateByPrimaryKeySelective(OrderComments record);

    int updateByPrimaryKey(OrderComments record);
}