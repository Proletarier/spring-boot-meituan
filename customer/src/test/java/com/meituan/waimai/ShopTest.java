package com.meituan.waimai;

import cn.hutool.core.io.file.FileReader;
import cn.hutool.core.util.NumberUtil;
import cn.hutool.core.util.ReUtil;
import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.meituan.waimai.mapper.*;
import com.meituan.waimai.model.*;
import com.meituan.waimai.model.vo.FoodCategory;
import com.meituan.waimai.server.ShopServer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SpringBootTest
public class ShopTest {


    @Autowired
    ShopServer shopServer;
    @Autowired
    ProductMapper productMapper;
    @Autowired
    MenuMapper menuMapper;
    @Autowired
    MenuProductRelationMapper menuProductRelationMapper;
    @Autowired
    ProductDiscountMapper discountMapper;
    @Autowired
    ProductAttributeCategoryMapper attributeCategoryMapper;
    @Autowired
    ProductAttributeMapper productAttributeMapper;
    @Autowired
    ProductAttributeValueMapper productAttributeValueMapper;

    @Test
    public void getFood() {
        List<FoodCategory> foodCategories = shopServer.getFood(1);
        System.out.println(JSON.toJSONString(foodCategories));
    }

    @Test
    public void addFood() {
        FileReader fileReader = new FileReader("//Users/wenheng/Desktop/work/private/vue-meituan/mock/food2.json");
        String json = fileReader.readString();
        JSONObject jsonObject = JSON.parseObject(json);
        JSONArray categoryList = jsonObject.getJSONArray("categoryList");

        for (int i = 0; i < categoryList.size(); i++) {
            JSONObject category = categoryList.getJSONObject(i);
            String menuName = category.getString("categoryName");

            LambdaQueryWrapper<Menu> menuLambdaQueryWrapper = new LambdaQueryWrapper();
            menuLambdaQueryWrapper.eq(Menu::getMenuName, menuName);
            Menu menu = menuMapper.selectOne(menuLambdaQueryWrapper);
            Integer menuId;
            if (menu == null) {
                Menu newMenu = new Menu();
                newMenu.setMenuName(menuName);
                newMenu.setStatus(1);
                newMenu.setIcon(category.getString("iconUrl"));
                newMenu.setShopId(1);
                newMenu.setSort(i + 1);
                menuMapper.insert(newMenu);
                menuId = newMenu.getId();
            } else {
                menuId = menu.getId();
            }

            JSONArray spuList = category.getJSONArray("spuList");
            for (int j = 0; j < spuList.size(); j++) {
                JSONObject food = spuList.getJSONObject(j);
                String foodName = food.getString("spuName");
                LambdaQueryWrapper<Product> productLambdaQueryWrapper = new LambdaQueryWrapper();
                productLambdaQueryWrapper.eq(Product::getName, foodName);
                List<Product> products = productMapper.selectList(productLambdaQueryWrapper);

                Integer foodId;
                if (products != null && !products.isEmpty()) {
                    foodId = products.get(0).getId();
                } else {
                    Product product = new Product();
                    product.setShopId(1);
                    product.setName(foodName);
                    product.setImageUrl(food.getString("bigImageUrl"));
                    product.setIntroduce(food.getString("spuDesc"));
                    product.setPrice(food.getDouble("originPrice"));

                    JSONArray skuList = food.getJSONArray("skuList");
                    if (skuList != null && !skuList.isEmpty()) {
                        JSONObject sku = skuList.getJSONObject(0);
                        product.setBoxFee(sku.getDouble("boxFee"));

                    }
                    String unit = food.getString("unit");
                    if (StrUtil.isNotEmpty(unit)) {
                        Pattern pattern = Pattern.compile("\\d+");
                        Matcher matcher = pattern.matcher(unit);
                        while (matcher.find()) {
                            product.setWeight(Integer.getInteger(matcher.group()));
                        }
                    }

                    String praiseNumDecoded = food.getString("praiseNumDecoded");
                    String saleVolumeDecoded = food.getString("saleVolumeDecoded");
                    JSONObject sale = new JSONObject();
                    if (StrUtil.isNotEmpty(praiseNumDecoded)) {
                        String praiseNum = ReUtil.get("\\d+", praiseNumDecoded, 0);
                        if (NumberUtil.isNumber(praiseNum)) {
                            sale.put("praise_num", Integer.parseInt(praiseNum));
                        }
                    }
                    if (StrUtil.isNotEmpty(saleVolumeDecoded)) {
                        String sellNum = ReUtil.get("\\d+", saleVolumeDecoded, 0);
                        if (NumberUtil.isNumber(sellNum)) {
                            sale.put("sell_month_count",  Integer.parseInt(sellNum));
                        }
                    }
                    product.setSale(sale);
                    product.setMust(false);
                    product.setSellStatus(false);
                    productMapper.insert(product);
                    foodId = product.getId();

                    String spuPromotionInfo = food.getString("spuPromotionInfo");
                    if (StrUtil.isNotEmpty(spuPromotionInfo)) {
                        ProductDiscount productDiscount = new ProductDiscount();
                        productDiscount.setProductId(foodId);
                        productDiscount.setPrice(food.getDouble("currentPrice"));
                        productDiscount.setShopId(1);

                        String[] info = spuPromotionInfo.split(" ");
                        for (String promotion : info) {
                            if (promotion.contains("折")) {
                                String discount;
                                if (promotion.contains(".")) {
                                    discount = ReUtil.get("(\\d+\\.\\d+)", promotion, 0);
                                } else {
                                    discount = ReUtil.get("\\d+", promotion, 0);
                                }
                                productDiscount.setDiscount(Double.parseDouble(discount));
                            } else if (promotion.contains("限")) {
                                String count = ReUtil.get("\\d+", promotion, 0);
                                productDiscount.setCount(Integer.parseInt(count));
                            } else if (promotion.contains("起购")) {
                                String minNum = ReUtil.get("\\d+", promotion, 0);
                                productDiscount.setMinPurchaseNum(Integer.parseInt(minNum));
                            }
                        }
                        discountMapper.insert(productDiscount);
                    }

                    JSONArray spuAttrList = food.getJSONArray("spuAttrList");
                    if (spuAttrList != null && !spuAttrList.isEmpty()) {
                        for (int k = 0; k < spuAttrList.size(); k++) {
                            JSONObject spu = spuAttrList.getJSONObject(k);
                            String spuName = spu.getString("spuAttrName");

                            LambdaQueryWrapper<ProductAttributeCategory> categoryLambdaQueryWrapper = new LambdaQueryWrapper();
                            categoryLambdaQueryWrapper.eq(ProductAttributeCategory::getCategoryName, spuName);
                            categoryLambdaQueryWrapper.eq(ProductAttributeCategory::getShopId, 1);
                            ProductAttributeCategory attributeCategory = attributeCategoryMapper.selectOne(categoryLambdaQueryWrapper);

                            Integer cateId;
                            if (attributeCategory != null) {
                                cateId = attributeCategory.getId();
                            } else {
                                ProductAttributeCategory addCategory = new ProductAttributeCategory();
                                addCategory.setCategoryName(spuName);
                                addCategory.setShopId(1);
                                attributeCategoryMapper.insert(addCategory);
                                cateId = addCategory.getId();
                            }

                            JSONArray spuAttrValueList = spu.getJSONArray("spuAttrValueList");
                            for (int l = 0; l < spuAttrValueList.size(); l++) {
                                JSONObject spuAttr = spuAttrValueList.getJSONObject(l);
                                String attrValue = spuAttr.getString("attrValue");

                                LambdaQueryWrapper<ProductAttribute> productAttributeLambdaQueryWrapper = new LambdaQueryWrapper();
                                productAttributeLambdaQueryWrapper.eq(ProductAttribute::getProductAttributeCategoryId, cateId);
                                productAttributeLambdaQueryWrapper.eq(ProductAttribute::getName, attrValue);
                                ProductAttribute productAttribute = productAttributeMapper.selectOne(productAttributeLambdaQueryWrapper);

                                Integer productAttributeId;
                                if (productAttribute != null) {
                                    productAttributeId = productAttribute.getId();
                                } else {
                                    ProductAttribute addProductAttribute = new ProductAttribute();
                                    addProductAttribute.setName(attrValue);
                                    addProductAttribute.setProductAttributeCategoryId(cateId);
                                    productAttributeMapper.insert(addProductAttribute);
                                    productAttributeId = addProductAttribute.getId();
                                }

                                LambdaQueryWrapper<ProductAttributeValue> valueLambdaQueryWrapper = new LambdaQueryWrapper();
                                valueLambdaQueryWrapper.eq(ProductAttributeValue::getProductId, foodId);
                                valueLambdaQueryWrapper.eq(ProductAttributeValue::getProductAttributeCategoryId, cateId);
                                valueLambdaQueryWrapper.eq(ProductAttributeValue::getProductAttributeId, productAttributeId);

                                ProductAttributeValue productAttributeValue = productAttributeValueMapper.selectOne(valueLambdaQueryWrapper);
                                if(productAttributeValue  == null){
                                    ProductAttributeValue attributeValue = new ProductAttributeValue();
                                    attributeValue.setProductId(foodId);
                                    attributeValue.setProductAttributeCategoryId(cateId);
                                    attributeValue.setProductAttributeId(productAttributeId);
                                    productAttributeValueMapper.insert(attributeValue);
                                }
                            }
                        }
                    }
                }

                LambdaQueryWrapper<MenuProductRelation> menuProductRelationLambdaQueryWrapper = new LambdaQueryWrapper();
                menuProductRelationLambdaQueryWrapper.eq(MenuProductRelation::getProductId, foodId);
                menuProductRelationLambdaQueryWrapper.eq(MenuProductRelation::getMenuId, menuId);
                Long count = menuProductRelationMapper.selectCount(menuProductRelationLambdaQueryWrapper);
                if(count == 0){
                    MenuProductRelation relation = new MenuProductRelation();
                    relation.setMenuId(menuId);
                    relation.setProductId(foodId);
                    menuProductRelationMapper.insert(relation);
                }
            }

        }

    }
}
