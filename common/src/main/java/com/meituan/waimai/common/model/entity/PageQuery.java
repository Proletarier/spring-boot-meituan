package com.meituan.waimai.common.model.entity;

import lombok.Data;

@Data
public class PageQuery {

    private Integer pageNum=1;

    private Integer pageSize = 10;
}
