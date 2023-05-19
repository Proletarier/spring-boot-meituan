package com.meituan.waimai.server;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.google.common.collect.Lists;
import com.meituan.waimai.mapper.FullReductionMapper;
import com.meituan.waimai.mapper.ProductDiscountMapper;
import com.meituan.waimai.model.FullReduction;
import com.meituan.waimai.model.ProductDiscount;
import com.meituan.waimai.model.vo.Activity;
import com.meituan.waimai.model.vo.Food;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import static com.meituan.waimai.enums.ActivityEnum.*;

@Slf4j
@Service
public class ActivityService {

    @Autowired
    ProductDiscountMapper productDiscountMapper;
    @Autowired
    FullReductionMapper fullReductionMapper;


    public List<Activity> getActivity(Integer shopId) {

        if (shopId == null) {
            log.warn("shop id is null");
            return new ArrayList<>(0);
        }
        List<Activity> activityList = Lists.newArrayList();
        LambdaQueryWrapper<FullReduction> reductionLambdaQueryWrapper = new LambdaQueryWrapper();
        reductionLambdaQueryWrapper.eq(FullReduction::getShopId, shopId);
        List<FullReduction> fullReductionList = fullReductionMapper.selectList(reductionLambdaQueryWrapper);
        if (!fullReductionList.isEmpty()) {
            Activity activity = new Activity();
            activity.setActType(fullSubtraction.name());
            fullReductionList.sort(Comparator.comparing(FullReduction::getFullPrice));
            StringBuilder desc = new StringBuilder();
            fullReductionList.forEach(fullReduction ->
                    desc.append(String.format("满%s减%s;", transform(fullReduction.getFullPrice()), transform(fullReduction.getReducePrice())))
            );
            activity.setActDesc(desc.deleteCharAt(desc.length() - 1).toString());
            activityList.add(activity);
        }

        LambdaQueryWrapper<ProductDiscount> discountLambdaQueryWrapper = new LambdaQueryWrapper();
        discountLambdaQueryWrapper.eq(ProductDiscount::getShopId, shopId);
        List<ProductDiscount> productDiscounts = productDiscountMapper.selectList(discountLambdaQueryWrapper);
        if (!productDiscounts.isEmpty()) {
            Activity activity = new Activity();
            activity.setActType(discount.name());
            Optional<ProductDiscount> min = productDiscounts.stream().min(Comparator.comparing(ProductDiscount::getDiscount));
            min.ifPresent(productDiscount -> activity.setActDesc(String.format("折扣商品%s折起", transform(productDiscount.getDiscount()))));
            activityList.add(activity);
        }

        return activityList;
    }


    public void setActivityInfo(Food food){
        // 折扣商品
        LambdaQueryWrapper<ProductDiscount> discountLambdaQueryWrapper = new LambdaQueryWrapper();
        discountLambdaQueryWrapper.eq(ProductDiscount::getProductId, food.getFoodId());
        ProductDiscount discount = productDiscountMapper.selectOne(discountLambdaQueryWrapper);
        if (discount != null){
            StringBuilder promotionInfo = new StringBuilder();
            promotionInfo.append(String.format("%s折",transform(discount.getDiscount())));

            if(discount.getCount() !=null && discount.getCount()> 0){
                promotionInfo.append(String.format(" 限%s份",discount.getCount()));
            }

            if(discount.getMinPurchaseNum() !=null && discount.getMinPurchaseNum()> 0){
                promotionInfo.append(String.format(" %s份起购",discount.getMinPurchaseNum()));
            }
            food.setSpuPromotionInfo(promotionInfo.toString());
            food.setCurrentPrice(discount.getPrice());
        }else {
            food.setCurrentPrice(food.getOriginPrice());
        }
    }


    public Object transform(double value) {
        if (value == (int) value && value > 0) {
            return (int) value ;
        } else {
            return value;
        }
    }
}
