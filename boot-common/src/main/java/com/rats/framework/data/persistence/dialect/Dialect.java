package com.rats.framework.data.persistence.dialect;

/**
 * @author hanbing
 * @ClassName: Dialect
 * @Description: 数据库Dialect接口
 */
public interface Dialect {

    String buildCountSql(String sql);

    String buildSortSql(String sql, String sort);

    String buildPaginationSql(String sql, long offset, long limit);
}
