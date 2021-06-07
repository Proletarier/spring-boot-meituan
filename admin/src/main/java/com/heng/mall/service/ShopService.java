package com.heng.mall.service;

import com.heng.mall.dto.ShopInfo;
import com.heng.mall.model.Shop;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ShopService {

    /**
     * 创建商家
     *
     * @param shop
     * @return
     */
    @Transactional
    int createShop(ShopInfo shop);

    /**
     * 修改商家
     *
     * @param shop
     * @return
     */
    @Transactional
    int updateShop(ShopInfo shop);

    /**
     * 分页查询
     *
     * @param keyword
     * @param pageSize
     * @param pageNum
     * @return
     */
    List<Shop> list(String keyword, Integer pageSize, Integer pageNum);

    /**
     * 查询shop详细信息
     *
     * @param id
     * @return
     */
    ShopInfo getShopInById(Integer id);

}
