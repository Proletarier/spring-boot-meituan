package com.meituan.waimai.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.meituan.waimai.common.domain.CommonResult;
import com.meituan.waimai.common.domain.ObjectKeyConstants;
import com.meituan.waimai.model.dto.ShopFilter;
import com.meituan.waimai.model.vo.GoodsCategoryVo;
import com.meituan.waimai.model.vo.ShopVo;
import com.meituan.waimai.server.HomeService;
import com.meituan.waimai.mapper.ObjectKeyMapper;
import com.meituan.waimai.model.ObjectKey;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Api(tags = "首页")
@Slf4j
@RestController
@RequestMapping("/home")
public class HomeController {

	@Autowired
	HomeService homeService;

	@Autowired
	ObjectKeyMapper objectKeyMapper;

	@GetMapping(value = "/list/goods_menu")
	public CommonResult<List<GoodsCategoryVo>> listGoodsMenu(){
		return  CommonResult.success(homeService.listGoodsCategory());
	}

	@GetMapping(value = "/goods_cate")
	public CommonResult<Object> listGoodsCate(){
		ObjectKey objectKey = objectKeyMapper.selectOne(new QueryWrapper<ObjectKey>().lambda().eq(ObjectKey::getObjectKey, ObjectKeyConstants.HOME_FOOD_CATE));
		if(objectKey == null){
			return CommonResult.success();
		}else {
			return CommonResult.success(objectKey.getObjectValue());
		}
	}

	@GetMapping(value = "/filter_conditions")
	public CommonResult<Object> filterConditions(){
		ObjectKey objectKey = objectKeyMapper.selectOne(new QueryWrapper<ObjectKey>().lambda().eq(ObjectKey::getObjectKey, ObjectKeyConstants.FILTER_CONDITIONS));
		if(objectKey == null){
			return CommonResult.success();
		}else {
			return CommonResult.success(objectKey.getObjectValue());
		}
	}

	@GetMapping(value = "/getShops")
	public CommonResult<List<ShopVo>> getShops(ShopFilter shopFilter){
		return  CommonResult.success(homeService.getNearShop(shopFilter));
	}
}
