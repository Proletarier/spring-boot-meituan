package com.meituan.waimai.handler;

import com.meituan.waimai.bean.GeoPoint;
import com.meituan.waimai.bean.GeoPointConverter;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@MappedTypes(value = {GeoPoint.class})
public class GeometryTypeHandler  extends BaseTypeHandler<GeoPoint> {

    GeoPointConverter converter = new GeoPointConverter();

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, GeoPoint geoPoint, JdbcType jdbcType) throws SQLException {
        ps.setBytes(i, converter.to(geoPoint));
    }

    @Override
    public GeoPoint getNullableResult(ResultSet resultSet, String columnName) throws SQLException {
        return converter.from(resultSet.getBytes(columnName));
    }

    @Override
    public GeoPoint getNullableResult(ResultSet resultSet, int i) throws SQLException {
        return converter.from(resultSet.getBytes(i));
    }

    @Override
    public GeoPoint getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        return converter.from(callableStatement.getBytes(i));
    }

}
