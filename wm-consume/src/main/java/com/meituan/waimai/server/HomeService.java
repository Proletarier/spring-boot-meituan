package com.meituan.waimai.server;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.meituan.waimai.mapper.NearShopMapper;
import com.meituan.waimai.model.dto.ShopSearch;
import com.meituan.waimai.model.vo.GoodsCategoryVo;
import com.meituan.waimai.model.vo.ShopVo;
import com.meituan.waimai.mapper.ShopCategoryMapper;
import com.meituan.waimai.model.ShopCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HomeService {

	@Autowired
	private ShopCategoryMapper shopCategoryMapper;
	@Autowired
	private NearShopMapper shopMapper;

	public List<GoodsCategoryVo> listGoodsCategory() {

		LambdaQueryWrapper<ShopCategory> queryWrapper = new LambdaQueryWrapper();
		queryWrapper.eq(ShopCategory::getIsHome, "1");
		queryWrapper.orderByDesc(ShopCategory::getPriority);
		List<ShopCategory> categoryList = shopCategoryMapper.selectList(queryWrapper);

		return categoryList.stream().map(category -> GoodsCategoryVo.builder()
				.cateId(category.getId())
				.name(category.getName())
				.icon(category.getIcon()).build()
		).collect(Collectors.toList());
	}


	public List<ShopVo> getNearShop(ShopSearch shopSearch) {
		int offSet = (shopSearch.getNextStartIndex() - 1) * shopSearch.getLimit();
	    return shopMapper.selectNearShopMapper(shopSearch,offSet);
	}
}
