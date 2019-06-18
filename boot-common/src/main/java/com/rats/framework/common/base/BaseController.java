package com.rats.framework.common.base;

/**
 * Created by shangxiutao on 17/2/23.
 */
public abstract class BaseController{

    public ResultBean successData(Object content) {
        ResultBean bean = new ResultBean();
        bean.setCode(0);
        bean.setMsg("success");
        bean.setData(content);
        return bean;
    }

    public ResultBean failData(Object content) {
        ResultBean bean = new ResultBean();
        bean.setCode(-1);
        bean.setMsg("fail");
        bean.setData(content);
        return bean;
    }

}
