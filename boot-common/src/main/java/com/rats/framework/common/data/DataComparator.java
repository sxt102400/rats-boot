package com.rats.framework.common.data;

import org.apache.commons.lang3.StringUtils;

import java.util.Comparator;

/**
 * Created by sxt102400 on 2017/2/21.
 */
public class DataComparator implements Comparator {

    private String key;

    private int keyType;

    private String order;

    public DataComparator(String key, int keyType, String order) {
        this.key = key;
        this.keyType = keyType;
        this.order = StringUtils.upperCase(order);
    }

    public int compare(Object o1, Object o2) {
        DataTable data1 = (DataTable) o1;
        DataTable data2 = (DataTable) o2;

        if (order == DataSet.ORDER_ASC) {
            if (keyType == DataSet.TYPE_STRING) {
                String value1 = data1.getString(key);
                String value2 = data2.getString(key);
                return value1.compareTo(value2);
            } else if (keyType == DataSet.TYPE_INTEGER) {
                int value1 = data1.getInt(key);
                int value2 = data2.getInt(key);
                return value1 < value2 ? -1 : (value1 == value2 ? 0 : 1);
            } else if (keyType == DataSet.TYPE_DOUBLE) {
                double value1 = data1.getDouble(key);
                double value2 = data2.getDouble(key);
                return value1 < value2 ? -1 : (value1 == value2 ? 0 : 1);
            }
        } else {
            if (keyType == DataSet.TYPE_STRING) {
                String value1 = data1.getString(key);
                String value2 = data2.getString(key);
                return value2.compareTo(value1);
            } else if (keyType == DataSet.TYPE_INTEGER) {
                int value1 = data1.getInt(key);
                int value2 = data2.getInt(key);
                return value1 > value2 ? -1 : (value1 == value2 ? 0 : 1);
            } else if (keyType == DataSet.TYPE_DOUBLE) {
                double value1 = data1.getDouble(key);
                double value2 = data2.getDouble(key);
                return value1 > value2 ? -1 : (value1 == value2 ? 0 : 1);
            }
        }
        return 0;
    }
}
