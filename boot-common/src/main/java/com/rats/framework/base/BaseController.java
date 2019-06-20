package com.rats.framework.base;

/**
 *
 * @author hanbing
 * @since 1.0.0
 * @date 2019-0620
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
