package com.meituan.waimai.server;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.google.common.collect.Lists;
import com.meituan.waimai.mapper.FullReductionMapper;
import com.meituan.waimai.mapper.ProductDiscountMapper;
import com.meituan.waimai.model.FullReduction;
import com.meituan.waimai.model.ProductDiscount;
import com.meituan.waimai.model.vo.Activity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import static com.meituan.waimai.common.model.enums.Activity.firstSubtraction;
import static com.meituan.waimai.common.model.enums.Activity.discount;

@Slf4j
@Service
public class ActivityService {

    @Autowired
    ProductDiscountMapper productDiscountMapper;
    @Autowired
    FullReductionMapper fullReductionMapper;


    /**
     * 获取活动信息
     * @param shopId
     * @return
     */
    public List<Activity> getActivity(Integer shopId){
        List<Activity> activityList = Lists.newArrayList();

        LambdaQueryWrapper<FullReduction> reductionLambdaQueryWrapper = new LambdaQueryWrapper();
        reductionLambdaQueryWrapper.eq(FullReduction::getShopId, shopId);
        List<FullReduction> fullReductionList = fullReductionMapper.selectList(reductionLambdaQueryWrapper);
        if (!fullReductionList.isEmpty()) {
            Activity activity = new Activity();
            activity.setActType(firstSubtraction.name());
            fullReductionList.sort(Comparator.comparing(FullReduction::getFullPrice));
            StringBuilder desc = new StringBuilder();
            fullReductionList.forEach(fullReduction ->
                    desc.append(String.format("满%s减%s;", fullReduction.getFullPrice(), fullReduction.getReducePrice()))
            );
            activity.setActDesc(desc.deleteCharAt(desc.length() - 1).toString());
            activityList.add(activity);
        }

        LambdaQueryWrapper<ProductDiscount> discountLambdaQueryWrapper = new LambdaQueryWrapper();
        reductionLambdaQueryWrapper.eq(FullReduction::getShopId, shopId);
        List<ProductDiscount> productDiscounts = productDiscountMapper.selectList(discountLambdaQueryWrapper);
        if (!productDiscounts.isEmpty()) {
            Activity activity = new Activity();
            activity.setActType(discount.name());
            Optional<ProductDiscount> min = productDiscounts.stream().min(Comparator.comparing(ProductDiscount::getDiscount));
            min.ifPresent(productDiscount -> activity.setActDesc(String.format("折扣商品%s折起", productDiscount.getDiscount())));
            activityList.add(activity);
        }

        return  activityList;
    }

}
