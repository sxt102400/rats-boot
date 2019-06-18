package com.rats.framework.common.cache;

/**
 * Created by shangxiutao on 17/2/23.
 */
public interface ICacheData {

    /**
     * get key
     * @return Serializable
     * @throws Exception
     */
    public Object getKey() throws Exception;

    /**
     * get value
     * @return Serializable
     * @throws Exception
     */
    public Object getValue() throws Exception;

}
