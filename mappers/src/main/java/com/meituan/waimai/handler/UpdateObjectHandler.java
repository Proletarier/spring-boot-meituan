package com.meituan.waimai.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;

import java.util.Date;

public class UpdateObjectHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        this.strictInsertFill(metaObject,"createdDate", Date.class,new Date())
                .strictInsertFill(metaObject,"updatedDate", Date.class,new Date());
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.strictUpdateFill(metaObject,"updatedDate", Date.class,new Date());
    }

}
