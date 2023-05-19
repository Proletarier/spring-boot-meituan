package com.meituan.waimai.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ShopComment {

    private Integer shopId;
    private Double deliveryScore;
    private Double shopScore;
    private Double packScore;
    private Double qualityScore;
    private List<CommentLabel> commentLabels;
}
