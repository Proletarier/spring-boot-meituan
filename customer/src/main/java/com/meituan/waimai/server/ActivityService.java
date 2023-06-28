package com.meituan.waimai.server;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.google.common.collect.Lists;
import com.meituan.waimai.mapper.FullReductionMapper;
import com.meituan.waimai.mapper.ProductDiscountMapper;
import com.meituan.waimai.model.FullReduction;
import com.meituan.waimai.model.ProductDiscount;
import com.meituan.waimai.model.vo.Activity;
import com.meituan.waimai.model.vo.ActivityPolicy;
import com.meituan.waimai.model.vo.Discount;
import com.meituan.waimai.model.vo.Food;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.math.RoundingMode;
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

        List<Activity> activityList = Lists.newArrayList();
        LambdaQueryWrapper<FullReduction> reductionLambdaQueryWrapper = new LambdaQueryWrapper<>();
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

        LambdaQueryWrapper<ProductDiscount> discountLambdaQueryWrapper = new LambdaQueryWrapper<>();
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
        LambdaQueryWrapper<ProductDiscount> discountLambdaQueryWrapper = new LambdaQueryWrapper<>();
        discountLambdaQueryWrapper.eq(ProductDiscount::getProductId, food.getFoodId());
        ProductDiscount discount = productDiscountMapper.selectOne(discountLambdaQueryWrapper);
        ActivityPolicy policy = new ActivityPolicy();
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

            Discount  dis = new Discount();
            dis.setCount(discount.getCount());
            dis.setDiscount(discount.getDiscount());
            dis.setMinPurchaseNum(discount.getMinPurchaseNum());
            policy.setDiscount(dis);
        }else {
            food.setCurrentPrice(food.getOriginPrice());
        }

        food.setActivityPolicy(policy);
    }


    public DiscountPrice getDiscountPrice(@NotNull Integer shopId,@NotNull Integer productId,Integer purchaseCount,Double originPrice){

        LambdaQueryWrapper<ProductDiscount> discountLambdaQueryWrapper = new LambdaQueryWrapper<>();
        discountLambdaQueryWrapper.eq(ProductDiscount::getShopId, shopId);
        discountLambdaQueryWrapper.eq(ProductDiscount::getProductId,productId);
        ProductDiscount  productDiscount = productDiscountMapper.selectOne(discountLambdaQueryWrapper);
        if (productDiscount == null) {
            return  null;
        }

        DiscountPrice discountPrice = new DiscountPrice();
        if(productDiscount.getMinPurchaseNum() !=null && purchaseCount < productDiscount.getMinPurchaseNum()){
            discountPrice.setCount(productDiscount.getMinPurchaseNum());
        }else {
            discountPrice.setCount(purchaseCount);
        }

        int discountCount;
        int noDiscountCount = 0;
        if(productDiscount.getCount() != null && productDiscount.getCount() > 0 && discountPrice.getCount() >  productDiscount.getCount()){
            discountCount  =  productDiscount.getCount();
            noDiscountCount  =  discountPrice.getCount() - productDiscount.getCount();
        }else {
            discountCount  = discountPrice.getCount();;
        }

        BigDecimal discountQuantity =new BigDecimal(discountCount);
        BigDecimal discount = BigDecimal.valueOf(productDiscount.getDiscount());
        BigDecimal price = BigDecimal.valueOf(originPrice);

        BigDecimal discountedPrice  = price.multiply(discountQuantity).multiply(discount).movePointLeft(1).setScale(2, RoundingMode.HALF_UP);

        if(discountedPrice.doubleValue() == 0){
            discountedPrice = BigDecimal.valueOf(productDiscount.getPrice());
        }
        if(noDiscountCount > 0){
            double currentPrice = price.multiply(new BigDecimal(noDiscountCount)).add(discountedPrice).doubleValue();
            discountPrice.setCurrentPrice(currentPrice);
        }else {
            discountPrice.setCurrentPrice(discountedPrice.doubleValue());
        }
        BigDecimal purchase = new BigDecimal(discountPrice.getCount());
        discountPrice.setOriginPrice(price.multiply(purchase).doubleValue());

        return  discountPrice;
    }


    public Object transform(double value) {
        if (value == (int) value && value > 0) {
            return (int) value ;
        } else {
            return value;
        }
    }

    @Data
    public static class DiscountPrice {
        private Double currentPrice;
        private Double originPrice;
        private Integer count;
    }
}
