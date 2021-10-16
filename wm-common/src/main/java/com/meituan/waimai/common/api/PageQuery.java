package com.meituan.waimai.common.api;

import lombok.Data;

@Data
public class PageQuery {

    private Integer pageNum=1;

    private Integer pageSize = 10;
}
