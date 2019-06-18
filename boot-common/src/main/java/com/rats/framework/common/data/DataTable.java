package com.rats.framework.common.data;

import java.io.Serializable;
import java.util.Map;

public interface DataTable<K, V> extends Map<K,V>, Serializable {

    /**
     * get object
     *
     * @param name
     * @param def
     * @return Object
     */
    public Object get(String name, Object def);

    /**
     * get names
     *
     * @return String[]
     */
    public String[] getNames();

    /**
     * get string
     *
     * @param name
     * @return String
     */
    public String getString(String name);

    /**
     * get string
     *
     * @param name
     * @param defaultValue
     * @return String
     */
    public String getString(String name, String defaultValue);

    /**
     * 不允许为空
     * @param name
     * @return
     */
    public String getStringNotEmpty(String name);

    /**
     * 获取安全的字符串供SQL查询
     * @param name
     * @return
     */
    public String getStringForQuery(String name);

    /**
     * get string
     *
     * @param name
     * @param defaultValue
     * @return String
     */
    public String getStringForQuery(String name, String defaultValue);

    /**
     * get int
     *
     * @param name
     * @return int
     */
    public int getInt(String name);

    /**
     * get int
     *
     * @param name
     * @param defaultValue
     * @return int
     */
    public int getInt(String name, int defaultValue);

    public int getIntNotEmpty(String name);
    /**
     * get double
     *
     * @param name
     * @return double
     */
    public double getDouble(String name);

    /**
     * get double
     *
     * @param name
     * @param defaultValue
     * @return double
     */
    public double getDouble(String name, double defaultValue);

    public double getDoubleNotEmpty(String name);
    /**
     * get boolean
     *
     * @param name
     * @return boolean
     */
    public boolean getBoolean(String name);

    /**
     * get boolean
     *
     * @param name
     * @param defaultValue
     * @return boolean
     */
    public boolean getBoolean(String name, boolean defaultValue);

    /**
     * to json string
     *
     * @return str
     */
    public String toJSON();

}
