package com.meituan.waimai.service;

import com.meituan.waimai.dto.ShopCategoryQueryParam;
import com.meituan.waimai.dto.ShopCategoryWithChildrenItem;
import com.heng.mall.model.ShopCategory;

import java.util.List;

public interface ShopCategoryService {

    /**
     * 分页查询分类
     *
     * @param param
     * @param pageSize
     * @param pageNum
     * @return
     */
    List<ShopCategory> list(ShopCategoryQueryParam param, Integer pageSize, Integer pageNum);

    /**
     * 新增分类
     *
     * @param shopCategory
     * @return
     */
    int createShopCategory(ShopCategory shopCategory);

    /**
     * 修改分类
     *
     * @param shopCategory
     * @return
     */
    int updateShopCategory(ShopCategory shopCategory);

    /**
     * 修改商家分类状态
     *
     * @param cateId
     * @param status
     * @return
     */
    int updateStatus(Integer cateId, Integer status);

    /**
     * 查询分类详情
     *
     * @param cateId
     * @return
     */
    ShopCategory getShopCategory(Integer cateId);

    /**
     * 查询分类及子类
     */
    List<ShopCategoryWithChildrenItem> listWithChildrenMap();
}
