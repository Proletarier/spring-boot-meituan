package com.heng.mall.service;

import com.heng.mall.model.Promotion;

import java.util.List;

public interface PromotionService {

    List<Promotion> listPromotion(Integer promotionType);
}
