package com.rats.framework.common.data;

import com.rats.framework.common.utils.JSONUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;

public class DataMap<K,V> extends HashMap<K,V> implements DataTable<K,V>, Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * get names
     *
     * @return String[]
     */
    public String[] getNames() {
        String[] names = keySet().toArray(new String[0]);
        Arrays.sort(names);
        return names;
    }

    /**
     * get object
     *
     * @param name
     * @param def
     * @return Object
     */
    public Object get(String name, Object def) {
        Object value = get(name);
        return value == null ? def : value;
    }

    /**
     * get string
     *
     * @param name
     * @return String
     */
    public String getString(String name) {
        Object value = get(name);
        return value == null ? null : value.toString();
    }

    /**
     * get string
     *
     * @param name
     * @return String
     */
    public String getString(String name, String defaultValue) {
        return get(name, defaultValue).toString();
    }

    /**
     * get int
     *
     * @param name
     * @return int
     */
    public int getInt(String name) {
        return getInt(name, 0);
    }

    /**
     * get int
     *
     * @param name
     * @param defaultValue
     * @return int
     */
    public int getInt(String name, int defaultValue) {
        String value = getString(name, "");
        return "".equals(value) ? defaultValue : Integer.parseInt(value);
    }

    /**
     * get double
     *
     * @param name
     * @return double
     */
    public double getDouble(String name) {
        return getDouble(name, 0);
    }

    /**
     * get double
     *
     * @param name
     * @param defaultValue
     * @return double
     */
    public double getDouble(String name, double defaultValue) {
        String value = getString(name, "");
        return "".equals(value) ? defaultValue : Double.parseDouble(value);
    }

    /**
     * get boolean
     *
     * @param name
     * @return boolean
     */
    public boolean getBoolean(String name) {
        return getBoolean(name, false);
    }

    /**
     * get boolean
     *
     * @param name
     * @param defaultValue
     * @return boolean
     */
    public boolean getBoolean(String name, boolean defaultValue) {
        String value = getString(name, "");
        return "".equals(value) ? defaultValue : Boolean.valueOf(value).booleanValue();
    }

    /**
     * get string
     *
     * @param name
     * @return String
     */
    public String getStringForQuery(String name) {
        Object value = get(name);
        return value == null ? null : StringUtils.replace(value.toString(), "'", "''");
    }

    /**
     * get string
     *
     * @param name
     * @return String
     */
    public String getStringForQuery(String name, String defaultValue) {
        Object value = get(name);
        return value == null ? defaultValue : StringUtils.replace(value.toString(), "'", "''");
    }

    /**
     * get string
     *
     * @param name
     * @return String
     */
    public String getStringNotEmpty(String name) {
        String value =  getString(name);
        if(StringUtils.isBlank(value)){
            throw new RuntimeException(name+" can not empty ");
        }
        return value;
    }

    public int getIntNotEmpty(String name) {
        String value =  getString(name);
        if(StringUtils.isBlank(value)){
            throw new RuntimeException(name+" can not empty ");
        }
        return getInt(name);
    }

    public double getDoubleNotEmpty(String name) {
        String value =  getString(name);
        if(StringUtils.isBlank(value)){
            throw new RuntimeException(name+" can not empty ");
        }
        return getDouble(name);
    }

    /**
     * to json string
     *
     * @return str
     */
    @Override
    public String toJSON() {
        return JSONUtils.toJSONString(this);
    }
}
