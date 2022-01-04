package com.meituan.waimai.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum StatusEnum {

	VALID(1),
	INVALID(1);

	private int code;
}
