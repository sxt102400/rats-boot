package com.rats.framework.common.persistence.criteria;

import java.io.Serializable;

/**
 * @author hanbing
 * @ClassName: Order
 * @Description: 排序类，参考实现org.hibernate.criterion.Order
 */
public class Order implements Serializable {

    private boolean ascending;
    private boolean ignoreCase;
    private String propertyName;

    public static Order asc(String propertyName) {
        return new Order(propertyName, true);
    }

    public static Order desc(String propertyName) {
        return new Order(propertyName, false);
    }

    protected Order(String propertyName, boolean ascending) {
        this.propertyName = propertyName;
        this.ascending = ascending;
    }

    public Order ignoreCase() {
        this.ignoreCase = true;
        return this;
    }

    public String getPropertyName() {
        return this.propertyName;
    }

    public boolean isAscending() {
        return this.ascending;
    }

    public boolean isIgnoreCase() {
        return this.ignoreCase;
    }

    public String toString() {
        return this.propertyName + ' ' + (this.ascending ? "asc" : "desc");
    }
}
