package com.meituan.waimai.service.impl;


import com.meituan.waimai.mapper.PromotionMapper;
import com.meituan.waimai.model.Promotion;
import com.meituan.waimai.model.PromotionExample;
import com.meituan.waimai.service.PromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PromotionServiceImpl implements PromotionService {

    @Autowired
    private PromotionMapper promotionMapper;

    @Override
    public List<Promotion> listPromotion(Integer promotionType) {
        PromotionExample example = new PromotionExample();
        example.createCriteria().andPromotionTypeEqualTo(promotionType);
        return promotionMapper.selectByExample(example);
    }
}
