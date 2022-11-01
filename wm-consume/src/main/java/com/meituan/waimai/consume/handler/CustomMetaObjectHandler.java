package com.meituan.waimai.consume.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

public class CustomMetaObjectHandler implements MetaObjectHandler {

	@Override
	public void insertFill(MetaObject metaObject) {
		this.strictInsertFill(metaObject,"createdDate", Date.class,new Date())
				.strictInsertFill(metaObject,"createdBy", String.class,"admin")
				.strictInsertFill(metaObject,"updatedDate", Date.class,new Date())
				.strictInsertFill(metaObject,"updatedBy", String.class,"admin");
	}

	@Override
	public void updateFill(MetaObject metaObject) {
		this.strictUpdateFill(metaObject,"updatedDate", Date.class,new Date())
				.strictUpdateFill(metaObject,"updatedBy", String.class,"admin");
	}
}
