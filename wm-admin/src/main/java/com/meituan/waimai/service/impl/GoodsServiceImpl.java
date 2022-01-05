package com.meituan.waimai.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.meituan.waimai.dao.GoodsDao;
import com.meituan.waimai.dto.GoodsInfo;
import com.meituan.waimai.mapper.GoodsMapper;
import com.meituan.waimai.model.Goods;
import com.meituan.waimai.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class GoodsServiceImpl extends ServiceImpl<GoodsMapper, Goods> implements GoodsService {


    @Autowired
    private GoodsDao goodsDao;


    @Override
    public List<Goods> listGoods(Integer pageNum, Integer pageSize, Integer shopId, String name) {
        PageHelper.startPage(pageNum, pageSize);
        LambdaQueryWrapper<Goods> queryWrapper=new LambdaQueryWrapper();
        if (Objects.nonNull(shopId)){
            queryWrapper.eq(Goods::getShopId,shopId);
        }
        if (StrUtil.isNotBlank(name)){
            queryWrapper.eq(Goods::getName,name);
        }
        return list(queryWrapper);
    }


//    @Override
//    public int create(GoodsInfo goodsInfo) {
//        productMapper.insertSelective(goodsInfo);
//        Integer productId = goodsInfo.getId();
//        updateOrAddProductDetail(productId, goodsInfo.getDetailList());
//        //设置商品属性
//        insertAttributeValueList(productId, goodsInfo.getAttributeValueList());
//        return 1;
//    }

    @Override
    public GoodsInfo getGoodsInfo(Integer id) {
        return goodsDao.getGoodsInfo(id);
    }

//    private void updateOrAddProductDetail(Integer productId, List<ProductDetail> detailList) {
//
//        for (int i = 0; i < detailList.size(); i++) {
//            if (detailList.get(i).getId() == null) {
//                detailList.get(i).setParentId(productId);
//                detailMapper.insertSelective(detailList.get(i));
//            } else {
//                detailMapper.updateByPrimaryKeySelective(detailList.get(i));
//            }
//        }
//    }
//
//    private void insertAttributeValueList(Integer productId, List<ProductAttributeValue> list) {
//        for (int i = 0; i < list.size(); i++) {
//            list.get(i).setProductId(productId);
//            valueMapper.insertSelective(list.get(i));
//        }
//    }

}
