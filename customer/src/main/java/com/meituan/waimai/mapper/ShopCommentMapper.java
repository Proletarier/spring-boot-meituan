package com.meituan.waimai.mapper;

import com.meituan.waimai.model.vo.ShopComment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;


@Mapper
public interface ShopCommentMapper  {


    @Select({
            "SELECT  * from (",
            "SELECT 0 as id, count(*) as comment_count, CONCAT('全部(', count(*) ,')') as content  from `_comment` c WHERE  shop_id  = 1 ",
            "union all",
            "SELECT 1 as id, count(*) as comment_count, CONCAT('好评(', count(*) ,')') as content  from `_comment` c WHERE  shop_id  = 1 and good = 1 GROUP BY good",
            "union all",
            "SELECT 2 as id, count(*) as comment_count, CONCAT('差评(', count(*) ,')') as content  from `_comment` c WHERE  shop_id  = 1 and negative = 1 GROUP BY negative",
            "union all",
            "SELECT 3 as id, count(*) as comment_count, CONCAT('有图评价(', count(*) ,')') as content  from `_comment` c WHERE  shop_id  = 1 and picture = 1 GROUP BY picture",
            "union all",
            "SELECT 4 as id, count(*) as comment_count, CONCAT('味道赞(', count(*) ,')') as content  from `_comment` c WHERE  shop_id  = 1 and taste = 1 GROUP BY taste",
            "union all",
            "SELECT 5 as id, count(*) as comment_count, CONCAT('服务好(', count(*) ,')') as content  from `_comment` c WHERE  shop_id  = 1 and service = 1 GROUP BY service",
            "union all",
            "SELECT 6 as id, count(*) as comment_count, CONCAT('包装好(', count(*) ,')') as content  from `_comment` c WHERE  shop_id  = 1 and pack = 1 GROUP BY pack",
            "union all",
            "SELECT 7 as id, count(*) as comment_count, CONCAT('推荐(', count(*) ,')') as content  from `_comment` c WHERE  shop_id  = 1 and recommend = 1 GROUP BY recommend",
            "union all",
            "SELECT 8 as id, count(*) as comment_count, CONCAT('满意(', count(*) ,')') as content  from `_comment` c WHERE  shop_id  = 1 and satisfaction = 1 GROUP BY satisfaction",
            "union all",
            "SELECT 9 as id, count(*) as comment_count, CONCAT('分量足(', count(*) ,')') as content  from `_comment` c WHERE  shop_id  = 1 and weight = 1 GROUP BY weight",
            ") labels  where labels.comment_count > 0"
    })
    List<ShopComment.CommentLabel> selectCommentLabelList(@Param("shopId") Integer shopId);
}
