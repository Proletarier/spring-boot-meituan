package com.meituan.waimai;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.meituan.waimai.mapper.CategoryMapper;
import com.meituan.waimai.model.Category;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class FoodCategoryTest {

    @Autowired
    CategoryMapper mapper;


    @Test
    public void addDate() {
        String json = "{\"Categories\":[{\"all\":true,\"name\":\"全部品类\",\"count\":3464,\"cateId\":0,\"priority\":0},{\"all\":false,\"name\":\"美食\",\"count\":2016,\"cateId\":910,\"subCate\":[{\"all\":true,\"name\":\"全部\",\"count\":2016,\"cateId\":910,\"parentId\":910,\"priority\":0},{\"all\":false,\"name\":\"饺子馄饨\",\"count\":39,\"cateId\":101792,\"parentId\":910,\"priority\":0},{\"all\":false,\"name\":\"快餐便当\",\"count\":324,\"cateId\":100839,\"parentId\":910,\"priority\":0},{\"all\":false,\"name\":\"汉堡薯条\",\"count\":36,\"cateId\":100840,\"parentId\":910,\"priority\":0},{\"all\":false,\"name\":\"意面披萨\",\"count\":24,\"cateId\":101785,\"parentId\":910,\"priority\":0},{\"all\":false,\"name\":\"包子粥店\",\"count\":43,\"cateId\":101786,\"parentId\":910,\"priority\":0},{\"all\":false,\"name\":\"米粉面馆\",\"count\":172,\"cateId\":100842,\"parentId\":910,\"priority\":0},{\"all\":false,\"name\":\"麻辣烫冒菜\",\"count\":106,\"cateId\":101615,\"parentId\":910,\"priority\":0},{\"all\":false,\"name\":\"川湘菜\",\"count\":220,\"cateId\":101791,\"parentId\":910,\"priority\":0},{\"all\":false,\"name\":\"地方菜系\",\"count\":89,\"cateId\":100841,\"parentId\":910,\"priority\":0},{\"all\":false,\"name\":\"炸鸡炸串\",\"count\":112,\"cateId\":101979,\"parentId\":910,\"priority\":0},{\"all\":false,\"name\":\"特色小吃\",\"count\":122,\"cateId\":100944,\"parentId\":910,\"priority\":0},{\"all\":false,\"name\":\"能量西餐\",\"count\":41,\"cateId\":103728,\"parentId\":910,\"priority\":0},{\"all\":false,\"name\":\"夹馍饼类\",\"count\":24,\"cateId\":101790,\"parentId\":910,\"priority\":0},{\"all\":false,\"name\":\"鸭脖卤味\",\"count\":102,\"cateId\":101980,\"parentId\":910,\"priority\":0},{\"all\":false,\"name\":\"日料寿司\",\"count\":45,\"cateId\":100843,\"parentId\":910,\"priority\":0},{\"all\":false,\"name\":\"韩式料理\",\"count\":21,\"cateId\":101788,\"parentId\":910,\"priority\":0},{\"all\":false,\"name\":\"香锅干锅\",\"count\":85,\"cateId\":100845,\"parentId\":910,\"priority\":0},{\"all\":false,\"name\":\"火锅串串\",\"count\":220,\"cateId\":101789,\"parentId\":910,\"priority\":0},{\"all\":false,\"name\":\"龙虾烧烤\",\"count\":443,\"cateId\":100844,\"parentId\":910,\"priority\":0},{\"all\":false,\"name\":\"轻食沙拉\",\"count\":67,\"cateId\":102145,\"parentId\":910,\"priority\":0},{\"all\":false,\"name\":\"暖胃粉丝汤\",\"count\":22,\"cateId\":102463,\"parentId\":910,\"priority\":0},{\"all\":false,\"name\":\"东南亚菜\",\"count\":12,\"cateId\":102464,\"parentId\":910,\"priority\":0}],\"priority\":0},{\"all\":false,\"name\":\"美团专送\",\"count\":520,\"cateId\":960,\"subCate\":[{\"all\":true,\"name\":\"全部\",\"count\":520,\"cateId\":960,\"parentId\":960,\"priority\":0},{\"all\":false,\"name\":\"配送优惠\",\"count\":367,\"cateId\":102911,\"parentId\":960,\"priority\":0},{\"all\":false,\"name\":\"尝新推荐\",\"count\":4,\"cateId\":100928,\"parentId\":960,\"priority\":0},{\"all\":false,\"name\":\"快餐小吃\",\"count\":240,\"cateId\":102484,\"parentId\":960,\"priority\":0},{\"all\":false,\"name\":\"西餐披萨\",\"count\":45,\"cateId\":102485,\"parentId\":960,\"priority\":0},{\"all\":false,\"name\":\"地方菜\",\"count\":144,\"cateId\":102486,\"parentId\":960,\"priority\":0},{\"all\":false,\"name\":\"异国美食\",\"count\":47,\"cateId\":102487,\"parentId\":960,\"priority\":0},{\"all\":false,\"name\":\"火锅香锅\",\"count\":34,\"cateId\":102488,\"parentId\":960,\"priority\":0},{\"all\":false,\"name\":\"海鲜烧烤\",\"count\":210,\"cateId\":102489,\"parentId\":960,\"priority\":0},{\"all\":false,\"name\":\"甜品饮品\",\"count\":100,\"cateId\":100926,\"parentId\":960,\"priority\":0}],\"priority\":0},{\"all\":false,\"name\":\"甜点饮品\",\"count\":582,\"cateId\":19,\"subCate\":[{\"all\":true,\"name\":\"全部\",\"count\":582,\"cateId\":19,\"parentId\":19,\"priority\":0},{\"all\":false,\"name\":\"面包蛋糕\",\"count\":265,\"cateId\":100837,\"parentId\":19,\"priority\":0},{\"all\":false,\"name\":\"奶茶果汁\",\"count\":197,\"cateId\":1044,\"parentId\":19,\"priority\":0},{\"all\":false,\"name\":\"可口甜品\",\"count\":192,\"cateId\":1042,\"parentId\":19,\"priority\":0},{\"all\":false,\"name\":\"醒脑咖啡\",\"count\":80,\"cateId\":100000,\"parentId\":19,\"priority\":0},{\"all\":false,\"name\":\"凉茶冰淇淋\",\"count\":6,\"cateId\":100838,\"parentId\":19,\"priority\":0}],\"priority\":0},{\"all\":false,\"name\":\"早餐\",\"count\":357,\"cateId\":102011,\"subCate\":[{\"all\":true,\"name\":\"全部\",\"count\":357,\"cateId\":102011,\"parentId\":102011,\"priority\":0},{\"all\":false,\"name\":\"包子粥店\",\"count\":43,\"cateId\":102012,\"parentId\":102011,\"priority\":0},{\"all\":false,\"name\":\"米粉面馆\",\"count\":160,\"cateId\":102013,\"parentId\":102011,\"priority\":0},{\"all\":false,\"name\":\"饺子馄饨\",\"count\":39,\"cateId\":102014,\"parentId\":102011,\"priority\":0},{\"all\":false,\"name\":\"地方小吃\",\"count\":21,\"cateId\":102015,\"parentId\":102011,\"priority\":0},{\"all\":false,\"name\":\"豆浆饼类\",\"count\":31,\"cateId\":102016,\"parentId\":102011,\"priority\":0},{\"all\":false,\"name\":\"醒脑咖啡\",\"count\":80,\"cateId\":102465,\"parentId\":102011,\"priority\":0}],\"priority\":0},{\"all\":false,\"name\":\"正餐优选\",\"count\":294,\"cateId\":950,\"subCate\":[{\"all\":true,\"name\":\"全部\",\"count\":294,\"cateId\":950,\"parentId\":950,\"priority\":0},{\"all\":false,\"name\":\"地方菜系\",\"count\":192,\"cateId\":100029,\"parentId\":950,\"priority\":0},{\"all\":false,\"name\":\"火锅烧烤\",\"count\":78,\"cateId\":100025,\"parentId\":950,\"priority\":0},{\"all\":false,\"name\":\"快餐小吃\",\"count\":65,\"cateId\":100024,\"parentId\":950,\"priority\":0},{\"all\":false,\"name\":\"日韩料理\",\"count\":18,\"cateId\":100032,\"parentId\":950,\"priority\":0},{\"all\":false,\"name\":\"东南亚菜\",\"count\":18,\"cateId\":100030,\"parentId\":950,\"priority\":0},{\"all\":false,\"name\":\"轻食西餐\",\"count\":16,\"cateId\":100031,\"parentId\":950,\"priority\":0}],\"priority\":0},{\"all\":false,\"name\":\"夜宵\",\"count\":1794,\"cateId\":970,\"subCate\":[{\"all\":true,\"name\":\"全部\",\"count\":1794,\"cateId\":970,\"parentId\":970,\"priority\":0},{\"all\":false,\"name\":\"香锅烤鱼\",\"count\":784,\"cateId\":101179,\"parentId\":970,\"priority\":0},{\"all\":false,\"name\":\"热门小炒\",\"count\":447,\"cateId\":100040,\"parentId\":970,\"priority\":0},{\"all\":false,\"name\":\"龙虾烧烤\",\"count\":443,\"cateId\":100035,\"parentId\":970,\"priority\":0},{\"all\":false,\"name\":\"粥面饺子\",\"count\":229,\"cateId\":100044,\"parentId\":970,\"priority\":0},{\"all\":false,\"name\":\"火锅串串\",\"count\":220,\"cateId\":102479,\"parentId\":970,\"priority\":0},{\"all\":false,\"name\":\"鸭脖小吃\",\"count\":165,\"cateId\":100041,\"parentId\":970,\"priority\":0},{\"all\":false,\"name\":\"麻辣烫\",\"count\":140,\"cateId\":100042,\"parentId\":970,\"priority\":0},{\"all\":false,\"name\":\"炸鸡汉堡\",\"count\":137,\"cateId\":100038,\"parentId\":970,\"priority\":0},{\"all\":false,\"name\":\"意面披萨\",\"count\":24,\"cateId\":102481,\"parentId\":970,\"priority\":0}],\"priority\":0},{\"all\":false,\"name\":\"家常菜\",\"count\":303,\"cateId\":100209,\"subCate\":[{\"all\":true,\"name\":\"全部\",\"count\":303,\"cateId\":100209,\"parentId\":100209,\"priority\":0},{\"all\":false,\"name\":\"口味川湘\",\"count\":260,\"cateId\":100213,\"parentId\":100209,\"priority\":0},{\"all\":false,\"name\":\"特色私房\",\"count\":21,\"cateId\":100858,\"parentId\":100209,\"priority\":0},{\"all\":false,\"name\":\"北方佳肴\",\"count\":14,\"cateId\":100857,\"parentId\":100209,\"priority\":0},{\"all\":false,\"name\":\"粤菜茶餐厅\",\"count\":12,\"cateId\":100856,\"parentId\":100209,\"priority\":0},{\"all\":false,\"name\":\"江浙菜系\",\"count\":4,\"cateId\":100953,\"parentId\":100209,\"priority\":0},{\"all\":false,\"name\":\"西北菜\",\"count\":4,\"cateId\":101110,\"parentId\":100209,\"priority\":0},{\"all\":false,\"name\":\"云贵风味\",\"count\":1,\"cateId\":103982,\"parentId\":100209,\"priority\":0}],\"priority\":0},{\"all\":false,\"name\":\"能量西餐\",\"count\":155,\"cateId\":100191,\"subCate\":[{\"all\":true,\"name\":\"全部\",\"count\":155,\"cateId\":100191,\"parentId\":100191,\"priority\":0},{\"all\":false,\"name\":\"汉堡薯条\",\"count\":36,\"cateId\":100849,\"parentId\":100191,\"priority\":0},{\"all\":false,\"name\":\"意面披萨\",\"count\":24,\"cateId\":100850,\"parentId\":100191,\"priority\":0},{\"all\":false,\"name\":\"法意牛排\",\"count\":12,\"cateId\":100904,\"parentId\":100191,\"priority\":0}],\"priority\":0},{\"all\":false,\"name\":\"小吃馆\",\"count\":617,\"cateId\":100180,\"subCate\":[{\"all\":true,\"name\":\"全部\",\"count\":617,\"cateId\":100180,\"parentId\":100180,\"priority\":0},{\"all\":false,\"name\":\"鸡排鸭脖\",\"count\":214,\"cateId\":100906,\"parentId\":100180,\"priority\":0},{\"all\":false,\"name\":\"粥粉面馆\",\"count\":184,\"cateId\":100238,\"parentId\":100180,\"priority\":0},{\"all\":false,\"name\":\"麻辣烫\",\"count\":123,\"cateId\":100240,\"parentId\":100180,\"priority\":0},{\"all\":false,\"name\":\"地方小吃\",\"count\":86,\"cateId\":100369,\"parentId\":100180,\"priority\":0},{\"all\":false,\"name\":\"饺子馄饨\",\"count\":39,\"cateId\":100244,\"parentId\":100180,\"priority\":0},{\"all\":false,\"name\":\"暖胃粉丝汤\",\"count\":16,\"cateId\":100946,\"parentId\":100180,\"priority\":0},{\"all\":false,\"name\":\"凉皮肉夹馍\",\"count\":15,\"cateId\":100905,\"parentId\":100180,\"priority\":0}],\"priority\":0},{\"all\":false,\"name\":\"快食简餐\",\"count\":353,\"cateId\":100325,\"subCate\":[{\"all\":true,\"name\":\"全部\",\"count\":353,\"cateId\":100325,\"parentId\":100325,\"priority\":0},{\"all\":false,\"name\":\"快食盖饭\",\"count\":260,\"cateId\":100966,\"parentId\":100325,\"priority\":0},{\"all\":false,\"name\":\"便当寿司\",\"count\":41,\"cateId\":103980,\"parentId\":100325,\"priority\":0},{\"all\":false,\"name\":\"石锅拌饭\",\"count\":21,\"cateId\":103979,\"parentId\":100325,\"priority\":0},{\"all\":false,\"name\":\"黄焖鸡米饭\",\"count\":16,\"cateId\":100969,\"parentId\":100325,\"priority\":0},{\"all\":false,\"name\":\"香浓排骨饭\",\"count\":8,\"cateId\":100968,\"parentId\":100325,\"priority\":0},{\"all\":false,\"name\":\"咖喱饭\",\"count\":6,\"cateId\":103981,\"parentId\":100325,\"priority\":0},{\"all\":false,\"name\":\"煲仔饭\",\"count\":5,\"cateId\":100967,\"parentId\":100325,\"priority\":0}],\"priority\":0},{\"all\":false,\"name\":\"异国料理\",\"count\":147,\"cateId\":100321,\"subCate\":[{\"all\":true,\"name\":\"全部\",\"count\":147,\"cateId\":100321,\"parentId\":100321,\"priority\":0},{\"all\":false,\"name\":\"韩国料理\",\"count\":99,\"cateId\":102515,\"parentId\":100321,\"priority\":0},{\"all\":false,\"name\":\"韩式炸鸡\",\"count\":87,\"cateId\":102514,\"parentId\":100321,\"priority\":0},{\"all\":false,\"name\":\"日式简餐\",\"count\":22,\"cateId\":100852,\"parentId\":100321,\"priority\":0},{\"all\":false,\"name\":\"日本料理\",\"count\":22,\"cateId\":102513,\"parentId\":100321,\"priority\":0},{\"all\":false,\"name\":\"韩式简餐\",\"count\":4,\"cateId\":100853,\"parentId\":100321,\"priority\":0}],\"priority\":0},{\"all\":false,\"name\":\"鲜花蛋糕\",\"count\":1175,\"cateId\":23,\"subCate\":[{\"all\":true,\"name\":\"全部\",\"count\":1175,\"cateId\":23,\"parentId\":23,\"priority\":0},{\"all\":false,\"name\":\"浪漫鲜花\",\"count\":838,\"cateId\":1063,\"parentId\":23,\"priority\":0},{\"all\":false,\"name\":\"甜蜜蛋糕\",\"count\":244,\"cateId\":101563,\"parentId\":23,\"priority\":0},{\"all\":false,\"name\":\"免配送费\",\"count\":639,\"cateId\":101618,\"parentId\":23,\"priority\":0},{\"all\":false,\"name\":\"跨天预订\",\"count\":693,\"cateId\":102143,\"parentId\":23,\"priority\":0},{\"all\":false,\"name\":\"特惠满减\",\"count\":840,\"cateId\":101616,\"parentId\":23,\"priority\":0},{\"all\":false,\"name\":\"0元起送\",\"count\":705,\"cateId\":101617,\"parentId\":23,\"priority\":0}],\"priority\":0},{\"all\":false,\"name\":\"送药上门\",\"count\":57,\"cateId\":22,\"subCate\":[{\"all\":true,\"name\":\"全部\",\"count\":57,\"cateId\":22,\"parentId\":22,\"priority\":0},{\"all\":false,\"name\":\"常用药品\",\"count\":57,\"cateId\":100007,\"parentId\":22,\"priority\":0},{\"all\":false,\"name\":\"夜间送药\",\"count\":12,\"cateId\":102590,\"parentId\":22,\"priority\":0}],\"priority\":0}]}";

        JSONObject jsonObject = JSONObject.parseObject(json);
        JSONArray jsonArray = jsonObject.getJSONArray("Categories");

        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject object = jsonArray.getJSONObject(i);
            Category category = new Category();
            category.setName(object.getString("name"));
            category.setId(object.getInteger("cateId"));
            category.setParentId(object.getInteger("parentId"));
            if (!category.getName().contains("全部")) {
                try {
                    mapper.insert(category);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    System.out.println(JSON.toJSONString(category));
                }
            }

            JSONArray child = object.getJSONArray("subCate");
            if (child != null) {
                for (int j = 0; j < child.size(); j++) {
                    JSONObject childObject = child.getJSONObject(j);
                    Category childCategory = new Category();
                    childCategory.setName(childObject.getString("name"));
                    childCategory.setId(childObject.getInteger("cateId"));
                    childCategory.setParentId(childObject.getInteger("parentId"));
                    if (!childCategory.getName().contains("全部")) {
                        try {
                            mapper.insert(childCategory);
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                            System.out.println(JSON.toJSONString(childCategory));
                        }
                    }
                }
            }
        }

    }
}