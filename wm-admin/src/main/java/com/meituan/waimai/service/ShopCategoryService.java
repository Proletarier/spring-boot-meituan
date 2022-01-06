package com.meituan.waimai.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.meituan.waimai.dto.ShopCategoryQueryParam;
import com.meituan.waimai.dto.ShopCategoryWithChildrenItem;
import com.meituan.waimai.model.ShopCategory;

import java.util.List;

public interface ShopCategoryService extends IService<ShopCategory> {

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
    boolean createShopCategory(ShopCategory shopCategory);

    /**
     * 查询分类及子类
     */
    List<ShopCategoryWithChildrenItem> listWithChildrenMap();
}
