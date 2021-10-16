package com.meituan.waimai.service.impl;

import com.meituan.waimai.dao.RegionDao;
import com.meituan.waimai.dto.RegionWithChildrenItem;
import com.meituan.waimai.service.RegionService;
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
