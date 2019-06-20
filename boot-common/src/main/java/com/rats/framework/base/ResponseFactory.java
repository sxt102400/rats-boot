package com.rats.framework.base;

import java.io.Serializable;

/**
 *
 * @author hanbing
 * @since 1.0.0
 * @date 2019-06-20
 */
public abstract class ResponseFactory implements Serializable {
    /**
     * Field serialVersionUID
     */
    private static final long serialVersionUID = 1L;

    public static ResponseBean getSuccessResult(Object data) {
        ResponseBean bean = new ResponseBean<>();
        bean.setCode(ResponseBean.SUCCESS);
        bean.setMessage(ResponseBean.RESULT_SUCCESS);
        bean.setData(data);
        return bean;
    }
}
