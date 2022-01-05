package com.meituan.waimai.service;



import com.baomidou.mybatisplus.extension.service.IService;
import com.meituan.waimai.model.GoodsAttribute;

import java.util.List;


public interface GoodsAttributeService extends IService<GoodsAttribute> {

    List<GoodsAttribute> list(Integer pageNum, Integer pageSize, Integer cateId);

}
