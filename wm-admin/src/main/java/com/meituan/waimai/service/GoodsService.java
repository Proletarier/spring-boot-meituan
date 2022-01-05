package com.meituan.waimai.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.meituan.waimai.dto.GoodsInfo;
import com.meituan.waimai.model.Goods;

import java.util.List;

public interface GoodsService extends IService<Goods> {

    List<Goods> listGoods(Integer pageNum, Integer pageSize, Integer shopId, String name);

    GoodsInfo getGoodsInfo(Integer id);
}
