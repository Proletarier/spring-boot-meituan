package com.meituan.waimai.dto;


import com.meituan.waimai.model.Goods;
import com.meituan.waimai.model.GoodsAttributeValue;
import lombok.Data;

import java.util.List;


@Data
public class GoodsInfo extends Goods {


    private List<GoodsAttributeValue> attributeValueList;
}
