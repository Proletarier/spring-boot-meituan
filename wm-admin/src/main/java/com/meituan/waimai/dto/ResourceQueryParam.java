package com.meituan.waimai.dto;

import com.meituan.waimai.common.domain.PageQuery;
import lombok.Data;

@Data
public class ResourceQueryParam  extends PageQuery {

    /**
     * 资源名称
     */
    private String name;

    /**
     * 资源路径
     */
    private String url;

    /**
     * 资源分类
     */
    private Integer categoryId;
}
