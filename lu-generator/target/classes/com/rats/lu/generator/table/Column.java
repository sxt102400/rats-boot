package com.rats.lu.generator.table;

import com.rats.lu.generator.utils.StringTools;
import com.rats.lu.generator.utils.TypeResolver;

/**
 * Copyright (C) 2016 
 * <p/>
 *
 * @author : hanbing
 * @version : v1.0
 * @since : 2016/12/12
 */
public class Column {
    private String column;
    private String field;
    private String defaultValue;
    private String remark;
    private int columnSize;
    private int decimalDigits;

    private int dataType;
    private String javaType;
    private String jdbcType;
    private String javaTypeFull;

    private boolean index;
    private boolean unique;
    private boolean nullable;
    private boolean primaryKey;
    private boolean foreignkey;
    private boolean autoIncrement;

    public void initialize() {
        this.field = StringTools.toCamel(column);
        this.jdbcType = TypeResolver.convertToJdbcType(dataType, getColumnSize());
        this.javaType = TypeResolver.convertToJavaType(dataType, getColumnSize());
        this.javaTypeFull = TypeResolver.convertToJavaTypeFull(dataType, getColumnSize());
    }

    public String getColumn() {
        return column;
    }

    public void setColumn(String column) {
        this.column = column;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public int getColumnSize() {
        return columnSize;
    }

    public void setColumnSize(int columnSize) {
        this.columnSize = columnSize;
    }

    public int getDecimalDigits() {
        return decimalDigits;
    }

    public void setDecimalDigits(int decimalDigits) {
        this.decimalDigits = decimalDigits;
    }

    public int getDataType() {
        return dataType;
    }

    public void setDataType(int dataType) {
        this.dataType = dataType;
    }

    public String getJavaType() {
        return javaType;
    }

    public void setJavaType(String javaType) {
        this.javaType = javaType;
    }

    public String getJdbcType() {
        return jdbcType;
    }

    public void setJdbcType(String jdbcType) {
        this.jdbcType = jdbcType;
    }

    public String getJavaTypeFull() {
        return javaTypeFull;
    }

    public void setJavaTypeFull(String javaTypeFull) {
        this.javaTypeFull = javaTypeFull;
    }

    public boolean isIndex() {
        return index;
    }

    public void setIndex(boolean index) {
        this.index = index;
    }

    public boolean isUnique() {
        return unique;
    }

    public void setUnique(boolean unique) {
        this.unique = unique;
    }

    public boolean isNullable() {
        return nullable;
    }

    public void setNullable(boolean nullable) {
        this.nullable = nullable;
    }

    public boolean isPrimaryKey() {
        return primaryKey;
    }

    public void setPrimaryKey(boolean primaryKey) {
        this.primaryKey = primaryKey;
    }

    public boolean isForeignkey() {
        return foreignkey;
    }

    public void setForeignkey(boolean foreignkey) {
        this.foreignkey = foreignkey;
    }

    public boolean isAutoIncrement() {
        return autoIncrement;
    }

    public void setAutoIncrement(boolean autoIncrement) {
        this.autoIncrement = autoIncrement;
    }
}
