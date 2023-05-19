package com.meituan.waimai.model.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Categories {

    private Boolean all;
    private Integer cateId;
    private String name;
    private Integer parentId;
    private Integer count;
    private List<Categories> subCate;



}
