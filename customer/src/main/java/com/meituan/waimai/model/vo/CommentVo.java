package com.meituan.waimai.model.vo;

import com.alibaba.fastjson.JSONArray;
import lombok.Data;

@Data
public class CommentVo {

    private String commentTime;
    private String content;
    private String deliveryTime;
    private JSONArray pictures;
    private String praiseDish;
    private Double score;
    private String shopReply;
    private String userName;
    private String userPicUrl;

}
