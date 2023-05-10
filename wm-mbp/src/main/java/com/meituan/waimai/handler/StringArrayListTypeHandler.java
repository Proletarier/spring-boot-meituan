package com.meituan.waimai.handler;

import cn.hutool.core.util.StrUtil;
import com.google.common.collect.Lists;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StringArrayListTypeHandler extends BaseTypeHandler<ArrayList<String>> {


    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, ArrayList<String> parameter, JdbcType jdbcType) throws SQLException {
        StringBuilder str = new StringBuilder(parameter.toString());
        ps.setString(i, str.substring(1, str.length() - 1));
    }

    @Override
    public ArrayList<String> getNullableResult(ResultSet rs, String columnName) throws SQLException {
        String  value = rs.getString(columnName);
        if(StrUtil.isNotEmpty(value)){
            return Lists.newArrayList(value.split(","));
        }
        return  null;
    }

    @Override
    public ArrayList<String> getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        String  value = rs.getString(columnIndex);
        return Lists.newArrayList(value.split(","));
    }

    @Override
    public ArrayList<String> getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        String  value = cs.getString(columnIndex);
        return Lists.newArrayList(value.split(","));
    }
}
