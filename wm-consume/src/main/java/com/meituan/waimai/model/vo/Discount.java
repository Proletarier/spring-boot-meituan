package com.meituan.waimai.model.vo;

import lombok.Builder;
import lombok.Data;


@Builder
@Data
public class Discount {

    private String info;
    private String iconUrl;
}
