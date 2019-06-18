package com.rats.framework.common.data;


import com.rats.framework.common.utils.JSONUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class DataSetList<E> extends ArrayList<E> implements DataSet<E> {

    private static final long serialVersionUID = 1L;
    private String serializableId;
    private String serializablePath;
    private boolean serializable;
    private boolean batchSerializable;
    private int pageSize;
    private int pageCount;

    /**
     * construct function
     */
    public DataSetList() {
        super();
    }

    /**
     * construct function
     *
     * @param list
     */
    public DataSetList(List list) {
        addAll(list);
    }

    /**
     * get serializable id
     *
     * @return String
     */
    public String getSerializableId() {
        return serializableId;
    }

    /**
     * set serializable id
     *
     * @param serializableId
     */
    public void setSerializableId(String serializableId) {
        this.serializableId = serializableId;
    }

    /**
     * get serializable path
     *
     * @return String
     */
    public String getSerializablePath() {
        return serializablePath;
    }

    /**
     * set serializable path
     *
     * @param serializablePath
     */
    public void setSerializablePath(String serializablePath) {
        this.serializablePath = serializablePath;
    }

    /**
     * is serializable
     *
     * @return boolean
     */
    public boolean isSerializable() {
        return serializable;
    }

    /**
     * set serializable
     *
     * @param serializable
     */
    public void setSerializable(boolean serializable) {
        this.serializable = serializable;
    }

    /**
     * set batch page size
     *
     * @return int
     */
    public int getPageSize() {
        return pageSize;
    }

    /**
     * set batch page size
     *
     * @param pageSize
     */
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    /**
     * set batch page count
     *
     * @return int
     */
    public int getPageCount() {
        return pageCount;
    }

    /**
     * set batch page count
     *
     * @param pageCount
     */
    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    /**
     * get object
     *
     * @param index
     * @param name
     * @return Object
     */
    public Object get(int index, String name) {
        DataTable dataTable = (DataTable) get(index);
        return dataTable == null ? null : dataTable.get(name);
    }

    /**
     * get object
     *
     * @param index
     * @param name
     * @param def
     * @return Object
     */
    public Object get(int index, String name, Object def) {
        Object value = get(index, name);
        return value == null ? def : value;
    }

    /**
     * get names
     *
     * @return String[]
     */
    public String[] getNames() {
        return size() > 0 ? ((DataTable) get(0)).getNames() : null;
    }

    /**
     * to data
     *
     * @return IData
     */
    public DataTable toData() throws Exception {
        DataTable dataTable = new DataMap();
        Iterator it = iterator();
        while (it.hasNext()) {
            DataTable element = (DataTable) it.next();
            Iterator iterator = element.keySet().iterator();
            while (iterator.hasNext()) {
                String key = (String) iterator.next();
                if (dataTable.containsKey(key)) {
                    List list = (List) dataTable.get(key);
                    list.add(element.get(key));
                } else {
                    List list = new ArrayList();
                    list.add(element.get(key));
                    dataTable.put(key, list);
                }
            }
        }

        return dataTable;
    }

    /**
     * get count
     *
     * @return int
     */
    public int count() {
        return size();
    }

    /**
     * sort single (default ascend)
     */
    public void sort(String key, int keyType) {
        sort(key, keyType, ORDER_ASC);
    }

    /**
     * sort single
     */
    public void sort(String key, int keyType, String order) {
        Object[] datas = this.toArray();
        DataComparator c = new DataComparator(key, keyType, order);
        Arrays.sort(datas, c);
        List list = Arrays.asList(datas);
        this.clear();
        this.addAll(list);
    }


    public DataTable getFirst() throws Exception {
        if (null == this || this.size() == 0) {
            return null;
        }
        return (DataTable) this.get(0);
    }

    @Override
    public String toJSON() {
        return JSONUtils.toJSONString(this);
    }

}
