package com.meituan.waimai.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.google.common.collect.Lists;
import com.meituan.waimai.bean.CustomerContext;
import com.meituan.waimai.common.domain.CommonResult;
import com.meituan.waimai.common.domain.ObjectKeyConstants;
import com.meituan.waimai.mapper.CategoryMapper;
import com.meituan.waimai.mapper.ObjectKeyMapper;
import com.meituan.waimai.model.Category;
import com.meituan.waimai.model.ObjectKey;
import com.meituan.waimai.model.dto.ShopFilter;
import com.meituan.waimai.model.vo.Categories;
import com.meituan.waimai.model.vo.FilterConditions;
import com.meituan.waimai.model.vo.FoodMenu;
import com.meituan.waimai.model.vo.NearShops;
import com.meituan.waimai.server.ShopServer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("/api/home")
public class HomeController {

    @Autowired
    ShopServer shopServer;
    @Autowired
    CategoryMapper categoryMapper;
    @Autowired
    ObjectKeyMapper objectKeyMapper;


    @GetMapping(value = "/goods_cate")
    public CommonResult<List<FoodMenu>> listGoodsCate() {

        LambdaQueryWrapper<Category> queryWrapper = new LambdaQueryWrapper();
        queryWrapper.eq(Category::getIsHome, true);
        List<Category> categoryList = categoryMapper.selectList(queryWrapper);
        if (categoryList.isEmpty()) {
            log.warn("[getFoodMenu] home menu set is null");
            return CommonResult.success(new ArrayList<>(0));
        }

        Map<Integer, Category> categoryMap = new HashMap<>();
        for (Category category : categoryList) {
            categoryMap.put(category.getId(), category);
        }

        List<Integer> result = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        for (Category category : categoryList) {
            dfs(category.getId(), categoryMap, visited, result);
        }

       List<FoodMenu> foodMenuList = result.stream().filter(Objects::nonNull).map(id -> {
            Category category = categoryMap.get(id);
            return FoodMenu.builder()
                    .cateId(category.getId())
                    .name(category.getName())
                    .icon(category.getIcon()).build();
        }).collect(Collectors.toList());

        log.info("SUCCESS|listGoodsCate|{}", CustomerContext.getCustomerId());
        return CommonResult.success(foodMenuList);
    }

    @GetMapping(value = "/filter_conditions")
    public CommonResult<Object> filterConditions() {

        FilterConditions result = new FilterConditions();
        ObjectKey objectKey = objectKeyMapper.selectOne(new QueryWrapper<ObjectKey>().lambda().eq(ObjectKey::getObjectKey, ObjectKeyConstants.FILTER_CONDITIONS));
        result.setMultifilterVOList(objectKey.getObjectValue().getJSONArray("multifilterVOList"));
        result.setSortVOList(objectKey.getObjectValue().getJSONArray("sortVOList"));

        log.info("SUCCESS|filterConditions|{}", CustomerContext.getCustomerId());
        return CommonResult.success(result);
    }

    @GetMapping(value = "/categoriesByChildren")
    public CommonResult<Object> categoriesByChildren() {

        List<Category> categoryList = categoryMapper.selectList(new LambdaQueryWrapper<Category>().orderByAsc(Category::getCreatedDate));
        List<Categories> categoriesList = categoryList.stream().filter(cate -> cate.getParentId() == null).map(cate -> {
            Categories categories = new Categories();
            categories.setCateId(cate.getId());
            categories.setCount(cate.getCount());
            categories.setName(cate.getName());
            categories.setParentId(0);
            categories.setAll(true);
            categories.setSubCate(this.childHandel(cate, categoryList));
            return categories;
        }).filter(cate -> cate.getSubCate().size() > 1).collect(Collectors.toList());

        categoriesList.add(0, Categories.builder().all(true).cateId(0).name("全部品类")
                .count(0).build());

        log.info("SUCCESS|categoriesByChildren|{}", CustomerContext.getCustomerId());
        return CommonResult.success(categoriesList);
    }

    @PostMapping(value = "/getShops")
    public CommonResult<NearShops> getNearShop(@Validated @RequestBody ShopFilter shopFilter) {
        NearShops shops = shopServer.getNearShop(shopFilter);
        log.info("SUCCESS|getNearShop|{}", CustomerContext.getCustomerId());
        return CommonResult.success(shops);
    }

    private void dfs(Integer id, Map<Integer, Category> map, Set<Integer> visited, List<Integer> result) {
        if (visited.contains(id)) {
            return;
        }
        visited.add(id);
        if (!map.containsKey(id)) {
            result.add(id);
            return;
        }
        dfs(map.get(id).getPreId(), map, visited, result);
        result.add(id);
    }

    private List<Categories> childHandel(Category parent, List<Category> categoryList) {
        List<Categories> childList = Lists.newArrayList();

        Categories self = new Categories();
        self.setCateId(parent.getId());
        self.setCount(parent.getCount());
        self.setName("全部");
        self.setParentId(parent.getId());
        self.setAll(true);
        childList.add(self);

        for (Category cate : categoryList) {
            if (parent.getId().equals(cate.getParentId())) {
                Categories categories = new Categories();
                categories.setCateId(cate.getId());
                categories.setCount(cate.getCount());
                categories.setName(cate.getName());
                categories.setParentId(cate.getParentId());
                childList.add(categories);
            }
        }

        return childList;
    }
}
