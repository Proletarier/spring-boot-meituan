package com.meituan.waimai.common.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class CustomMetaObjectHandler implements MetaObjectHandler {

	@Override
	public void insertFill(MetaObject metaObject) {
		this.strictInsertFill(metaObject,"createDate", Date.class,new Date())
				.strictInsertFill(metaObject,"createBy", String.class,"admin")
				.strictInsertFill(metaObject,"updateDate", Date.class,new Date())
				.strictInsertFill(metaObject,"updateBy", String.class,"admin");
	}

	@Override
	public void updateFill(MetaObject metaObject) {
		this.strictUpdateFill(metaObject,"updateDate", Date.class,new Date())
				.strictUpdateFill(metaObject,"updateBy", String.class,"admin");
	}
}
