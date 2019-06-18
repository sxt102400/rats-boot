package com.rats.framework.common.base;

/**
 * Created by shangxiutao on 17/2/23.
 */
public abstract class BaseController{

    public ResponseBean successData(Object content) {
        ResponseBean bean = new ResponseBean();
        bean.setCode(0);
        bean.setMessage("success");
        bean.setData(content);
        return bean;
    }

    public ResponseBean failData(Object content) {
        ResponseBean bean = new ResponseBean();
        bean.setCode(-1);
        bean.setMessage("fail");
        bean.setData(content);
        return bean;
    }

}
