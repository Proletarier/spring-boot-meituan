package com.meituan.waimai.service;

import com.meituan.waimai.model.Promotion;

import java.util.List;

public interface PromotionService {

    List<Promotion> listPromotion(Integer promotionType);
}
