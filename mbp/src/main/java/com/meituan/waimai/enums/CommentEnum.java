package com.meituan.waimai.enums;

import lombok.Getter;

@Getter
public enum CommentEnum {

    ALL("全部(%s)",0,1),
    GOOD("好评(%s)",1,0),
    NEGATIVE("差评(%s)",2,0),
    PICTURE("有图评价(%s)",3,0),
    TASTE("味道赞(%s)",4,0),
    SERVICE("服务好(%s)",5,0),
    PACK("包装好(%s)",6,0),
    RECOMMEND("推荐(%s)",7,0),
    SATISFACTION("满意(%s)",8,0),
    WEIGHT("分量足(%s)",9,0);

    private final String content;
    private final Integer id;
    private final Integer isSelected;

    CommentEnum(String content, Integer id, Integer isSelected){
        this.content = content;
        this.id = id;
        this.isSelected = isSelected;
   }
}
