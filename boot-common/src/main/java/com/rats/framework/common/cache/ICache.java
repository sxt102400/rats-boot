package com.rats.framework.common.cache;

import java.io.Serializable;
import java.util.List;

public interface ICache {

    /**
     * put element
     * @param element
     * @throws Exception
     */
    public void put(ICacheData element) throws Exception;

    /**
     * put element
     * @param key
     * @param value
     * @throws Exception
     */
    public void put(Serializable key, Serializable value) throws Exception;

    /**
     * get element
     * @param key
     * @return ICacheElement
     * @throws Exception
     */
    public ICacheData get(Serializable key) throws Exception;

    /**
     * remove element
     * @param key
     * @return boolean
     * @throws Exception
     */
    public boolean remove(Serializable key) throws Exception;

    /**
     * remove all element
     * @throws Exception
     */
    public void removeAll() throws Exception;

    /**
     * get name
     * @return String
     * @throws Exception
     */
    public String getName() throws Exception;

    /**
     * get status
     * @return int
     * @throws Exception
     */
    public int getStatus() throws Exception;

    /**
     * get keys
     * @return List
     * @throws Exception
     */
    public List getKeys() throws Exception;

    /**
     * get size
     * @return int
     * @throws Exception
     */
    public int getSize() throws Exception;
}
