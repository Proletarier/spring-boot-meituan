package com.meituan.waimai.server;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.meituan.waimai.mapper.DiscountMapper;
import com.meituan.waimai.mapper.NearShopMapper;
import com.meituan.waimai.model.Discount;
import com.meituan.waimai.model.dto.ShopFilter;
import com.meituan.waimai.model.vo.GoodsCategoryVo;
import com.meituan.waimai.model.vo.ShopVo;
import com.meituan.waimai.mapper.ShopCategoryMapper;
import com.meituan.waimai.model.ShopCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class HomeService {

    @Autowired
    private ShopCategoryMapper shopCategoryMapper;
    @Autowired
    private NearShopMapper shopMapper;
    @Autowired
    private DiscountMapper discountMapper;

    public List<GoodsCategoryVo> listGoodsCategory() {

        LambdaQueryWrapper<ShopCategory> queryWrapper = new LambdaQueryWrapper();
        queryWrapper.eq(ShopCategory::getIsHome, "1");
        queryWrapper.orderByDesc(ShopCategory::getPriority);
        List<ShopCategory> categoryList = shopCategoryMapper.selectList(queryWrapper);

        return categoryList.stream().map(category -> GoodsCategoryVo.builder()
                .cateId(category.getId())
                .name(category.getName())
                .icon(category.getIcon()).build()
        ).collect(Collectors.toList());
    }


    public List<ShopVo> getNearShop(ShopFilter shopFilter) {
        int offSet = (shopFilter.getNextStartIndex() - 1) * shopFilter.getLimit();

        List<ShopVo> shops = shopMapper.selectNearShopMapper(shopFilter, offSet);
        shops.forEach(shop -> {
            double meter = Double.parseDouble(shop.getDistance());
            if (meter < 1000) {
                shop.setDistance((int) meter + "m");
            } else {
                DecimalFormat df = new DecimalFormat("#.#km");
                shop.setDistance(df.format(meter / 1000));
            }
            LambdaQueryWrapper<Discount> queryWrapper = new LambdaQueryWrapper();
            queryWrapper.eq(Discount::getShopId, shop.getId());
            shop.setDiscountList(discountMapper.selectList(queryWrapper));
        });
        return shops;
    }
}
