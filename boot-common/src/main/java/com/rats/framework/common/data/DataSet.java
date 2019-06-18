package com.rats.framework.common.data;

import java.util.List;

/**
 * Created by sxt102400 on 2017/2/21.
 */
public interface DataSet<E> extends List<E> {

    /**
     * Sort order Constants
     */
    public static final String ORDER_ASC = "ASC";

    public static final String ORDER_DESC = "DESC";

    /**
     * Key type Constants
     */
    public static final int TYPE_STRING = 2;

    public static final int TYPE_INTEGER = 3;

    public static final int TYPE_DOUBLE = 4;



    /**
     * get serializable id
     *
     * @return String
     */
    public String getSerializableId();

    /**
     * set serializable id
     *
     * @param serializableId
     */
    public void setSerializableId(String serializableId);

    /**
     * get serializable path
     *
     * @return String
     */
    public String getSerializablePath();

    /**
     * set serializable path
     *
     * @param serializablePath
     */
    public void setSerializablePath(String serializablePath);

    /**
     * is serializable
     *
     * @return boolean
     */
    public boolean isSerializable();

    /**
     * set serializable
     *
     * @param serializable
     */
    public void setSerializable(boolean serializable);

    /**
     * set batch page size
     *
     * @return int
     */
    public int getPageSize();

    /**
     * set batch page size
     *
     * @param pageSize
     */
    public void setPageSize(int pageSize);

    /**
     * set batch page count
     *
     * @return int
     */
    public int getPageCount();

    /**
     * set batch page count
     *
     * @param pageCount
     */
    public void setPageCount(int pageCount);


    /**
     * get names
     *
     * @return String[]
     */
    public String[] getNames();

    /**
     * get count
     *
     * @return int
     */
    public int count();

    /**
     * get object
     *
     * @param index
     * @param name
     * @return Object
     */
    public Object get(int index, String name);

    /**
     * get object
     *
     * @param index
     * @param name
     * @param def
     * @return Object
     */
    public Object get(int index, String name, Object def);

    /**get first
     * @return
     * @throws Exception
     */
    public DataTable getFirst() throws Exception;

    /**
     * sort single (default ascend)
     */
    public void sort(String key, int type);

    /**
     * sort single
     */
    public void sort(String key, int type, String order);

    /**
     * to data
     *
     * @return IData
     */
    public DataTable toData() throws Exception;

    public String toJSON();
}
