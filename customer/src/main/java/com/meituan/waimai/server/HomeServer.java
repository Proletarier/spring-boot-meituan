package com.meituan.waimai.server;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.google.common.collect.Lists;
import com.meituan.waimai.common.domain.ObjectKeyConstants;
import com.meituan.waimai.mapper.CategoryMapper;
import com.meituan.waimai.mapper.ObjectKeyMapper;
import com.meituan.waimai.model.Category;
import com.meituan.waimai.model.ObjectKey;
import com.meituan.waimai.model.vo.Categories;
import com.meituan.waimai.model.vo.FilterConditions;
import com.meituan.waimai.model.vo.FoodMenu;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Slf4j
@Service
public class HomeServer {

    @Autowired
    private CategoryMapper categoryMapper;
    @Autowired
    ObjectKeyMapper objectKeyMapper;

    public List<FoodMenu> getFoodMenu() {

        LambdaQueryWrapper<Category> queryWrapper = new LambdaQueryWrapper();
        queryWrapper.eq(Category::getIsHome, true);
        List<Category> categoryList = categoryMapper.selectList(queryWrapper);

        if (categoryList.isEmpty()) {
            log.warn("[getFoodMenu] home menu set is null");
            return new ArrayList<>(0);
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

        return result.stream().filter(Objects::nonNull).map(id -> {
            Category category = categoryMap.get(id);
            return FoodMenu.builder()
                    .cateId(category.getId())
                    .name(category.getName())
                    .icon(category.getIcon()).build();
        }).collect(Collectors.toList());
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


    public FilterConditions getFilterConditions() {

        FilterConditions result = new FilterConditions();
        ObjectKey objectKey = objectKeyMapper.selectOne(new QueryWrapper<ObjectKey>().lambda().eq(ObjectKey::getObjectKey, ObjectKeyConstants.FILTER_CONDITIONS));
        result.setMultifilterVOList(objectKey.getObjectValue().getJSONArray("multifilterVOList"));
        result.setSortVOList(objectKey.getObjectValue().getJSONArray("sortVOList"));
        return result;
    }

    public List<Categories> categoriesByChildren() {
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

        return categoriesList;
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
