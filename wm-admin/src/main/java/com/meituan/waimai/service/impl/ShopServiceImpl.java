package com.meituan.waimai.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.meituan.waimai.dao.ShopDao;
import com.meituan.waimai.dto.ShopInfo;

import com.meituan.waimai.model.*;
import com.meituan.waimai.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopServiceImpl extends ServiceImpl<ShopMapper,Shop> implements ShopService {


    @Autowired
    private ShopDao shopDao;

    @Override
    public int createShop(ShopInfo shop) {
        //添加商家信息
        Shop shopParam = shop;
        shopParam.setId(null);
        save(shopParam);
        Integer shopId = shopParam.getId();
        //添加商品活动
//        updateOrAddShopPromotionDetails(shopId, shop.getShopPromotionDetails());
//        //添加商家资质信息
//        updateOrAddShopQualification(shop.getId(), shop.getShopQualification());
        return 1;
    }

    @Override
    public void updateShop(ShopInfo shop) {
        // 设置商品活动
//        ShopPromotionDetailsExample detailsExample = new ShopPromotionDetailsExample();
//        detailsExample.createCriteria().andShopIdEqualTo(shop.getId());
//        detailsMapper.deleteByExample(detailsExample);
//        updateOrAddShopPromotionDetails(shop.getId(), shop.getShopPromotionDetails());
//        //更新商家资质信息
//        updateOrAddShopQualification(shop.getId(), shop.getShopQualification());
//        //更新商家信息
//        shopMapper.updateByPrimaryKey(shop);
//        return 1;
    }

    @Override
    public List<Shop> list(String keyword, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
//        ShopExample shopExample = new ShopExample();
//        ShopExample.Criteria criteria = shopExample.createCriteria();
        return list();
    }

    @Override
    public ShopInfo getShopInById(Integer id) {
        return shopDao.getShopInfo(id);
    }

//    private void updateOrAddShopQualification(Integer shopId, ShopQualification qualification) {
//        if (qualification.getId() == null) {
//            qualification.setShopId(shopId);
//            qualificationMapper.insertSelective(qualification);
//        } else {
//            qualificationMapper.updateByPrimaryKey(qualification);
//        }
//    }
//
//    private void updateOrAddShopPromotionDetails(Integer shopId, List<ShopPromotionDetails> newList) {
//        // 设置商品活动
//        for (int i = 0; i < newList.size(); i++) {
//            ShopPromotionDetails details = newList.get(i);
//            details.setId(null);
//            details.setShopId(shopId);
//            detailsMapper.insertSelective(details);
//        }
//
//    }


}
