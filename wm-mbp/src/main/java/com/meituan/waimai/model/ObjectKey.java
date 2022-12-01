package com.meituan.waimai.model;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.handlers.FastjsonTypeHandler;

@TableName(value = "_object_key",autoResultMap = true)
public class ObjectKey  extends AbstractEntity{

    @TableField(value = "object_key")
    private String objectKey;

    @TableField(value = "object_value",typeHandler= FastjsonTypeHandler.class)
    private JSONObject objectValue;

    public String getObjectKey() {
        return objectKey;
    }

    public void setObjectKey(String objectKey) {
        this.objectKey = objectKey;
    }

    public JSONObject getObjectValue() {
        return objectValue;
    }

    public void setObjectValue(JSONObject objectValue) {
        this.objectValue = objectValue;
    }
}
