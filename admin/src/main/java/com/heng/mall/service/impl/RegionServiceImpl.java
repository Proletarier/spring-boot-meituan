package com.heng.mall.service.impl;

import com.heng.mall.dao.RegionDao;
import com.heng.mall.dto.RegionWithChildrenItem;
import com.heng.mall.service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegionServiceImpl implements RegionService {

    @Autowired
    private RegionDao regionDao;

    @Override
    public List<RegionWithChildrenItem> listWithChildren() {
        return regionDao.listWithChildren();
    }
}
