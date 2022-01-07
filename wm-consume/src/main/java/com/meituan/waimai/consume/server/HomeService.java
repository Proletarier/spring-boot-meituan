package com.meituan.waimai.consume.server;

import com.meituan.waimai.consume.model.vo.GoodsCategoryVo;

import java.util.List;

public interface HomeService  {

	/**
	 * 获取首页菜单
	 * @return
	 */
	List<GoodsCategoryVo>  listGoodsCategory();

	/**
	 * 附近商家
	 */
}
