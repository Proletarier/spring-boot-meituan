package com.heng.mall.service.impl;

import com.github.pagehelper.PageHelper;
import com.heng.mall.dao.ProductDao;
import com.heng.mall.dto.ProductInfo;
import com.heng.mall.mapper.ProductAttributeValueMapper;
import com.heng.mall.mapper.ProductDetailMapper;
import com.heng.mall.mapper.ProductMapper;
import com.heng.mall.model.*;
import com.heng.mall.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private ProductDao productDao;

    @Autowired
    private ProductDetailMapper detailMapper;

    @Autowired
    private ProductAttributeValueMapper valueMapper;

    @Override
    public List<Product> listProduct(Integer pageNum, Integer pageSize, Integer shopId, String name) {
        PageHelper.startPage(pageNum, pageSize);
        ProductExample example = new ProductExample();
        ProductExample.Criteria criteria = example.createCriteria();
        criteria.andShopIdEqualTo(shopId);
        if (StringUtils.hasText(name)) {
            criteria.andProductNameLike("%" + name + "%");
        }
        return productMapper.selectByExample(example);
    }

    @Override
    public int update(ProductInfo productInfo) {
        productMapper.updateByPrimaryKey(productInfo);
        updateOrAddProductDetail(productInfo.getId(), productInfo.getDetailList());
        //设置商品属性
        ProductAttributeValueExample example = new ProductAttributeValueExample();
        example.createCriteria().andProductIdEqualTo(productInfo.getId());
        valueMapper.deleteByExample(example);
        insertAttributeValueList(productInfo.getId(), productInfo.getAttributeValueList());
        return 1;
    }

    @Override
    public int create(ProductInfo productInfo) {
        productMapper.insertSelective(productInfo);
        Integer productId = productInfo.getId();
        updateOrAddProductDetail(productId, productInfo.getDetailList());
        //设置商品属性
        insertAttributeValueList(productId, productInfo.getAttributeValueList());
        return 1;
    }

    @Override
    public ProductInfo getProductInfo(Integer id) {
        return productDao.getProductInfo(id);
    }

    private void updateOrAddProductDetail(Integer productId, List<ProductDetail> detailList) {

        for (int i = 0; i < detailList.size(); i++) {
            if (detailList.get(i).getId() == null) {
                detailList.get(i).setParentId(productId);
                detailMapper.insertSelective(detailList.get(i));
            } else {
                detailMapper.updateByPrimaryKeySelective(detailList.get(i));
            }
        }
    }

    private void insertAttributeValueList(Integer productId, List<ProductAttributeValue> list) {
        for (int i = 0; i < list.size(); i++) {
            list.get(i).setProductId(productId);
            valueMapper.insertSelective(list.get(i));
        }
    }

}
