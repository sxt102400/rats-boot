package com.rats.lu.generator.table;

import java.util.ArrayList;
import java.util.List;

public class CompKey {

    /**
     * 主键列表
     */
    private String javaType;

    private String javaTypeFull;

    private String field;

    public List<Column> columns = new ArrayList<Column>();

    public String getJavaType() {
        return javaType;
    }

    public void setJavaType(String javaType) {
        this.javaType = javaType;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getJavaTypeFull() {
        return javaTypeFull;
    }

    public void setJavaTypeFull(String javaTypeFull) {
        this.javaTypeFull = javaTypeFull;
    }

    public List<Column> getColumns() {
        return columns;
    }

    public void setColumns(List<Column> columns) {
        this.columns = columns;
    }
}
