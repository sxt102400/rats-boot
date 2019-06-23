package com.rats.framework.common.response;

import java.io.Serializable;

/**
 * @author hanbing
 * @date 2019-06-20
 * @since 1.0.0
 */
public abstract class ResponseFactory implements Serializable {

    private static final long serialVersionUID = 1L;

    public static <T> ResponseBean<T> getSuccessResponse(T data) {
        ResponseBean<T> response = new ResponseBean<T>();
        response.setData(data);
        response.setCode(ResponseCode.SUCCESS.code());
        response.setMessage(ResponseCode.SUCCESS.message());
        return response;
    }

    /**
     * 获取默认操作成功Response.
     *
     * @return
     */
    public static <T> ResponseBean<T> getDefaultSuccessResponse() {
        ResponseBean<T> response = new ResponseBean<T>();
        response.setCode(ResponseCode.SUCCESS.code());
        response.setMessage(ResponseCode.SUCCESS.message());
        return response;
    }

    public static <T> ResponseBean<T> getDefaultSuccessResponse(String msg) {
        ResponseBean<T> response = getDefaultSuccessResponse();
        response.setMessage(msg);
        return response;
    }

    /**
     * 获取默认操作失败Response.
     *
     * @return
     */
    public static <T> ResponseBean<T> getDefaultFailureResponse() {
        ResponseBean<T> response = new ResponseBean<T>();
        response.setCode(ResponseCode.FAILURE.code());
        response.setMessage(ResponseCode.FAILURE.message());
        return response;
    }

    public static <T> ResponseBean<T> getDefaultFailureResponse(String msg) {
        ResponseBean<T> response = getDefaultFailureResponse();
        response.setMessage(msg);
        return response;
    }

    public static <T> ResponseBean<T> getDefaultFailureResponse(int code, String msg) {
        ResponseBean<T> response = getDefaultFailureResponse();
        response.setCode(code);
        response.setMessage(msg);
        return response;
    }

    /**
     * 获取默认输入操作失败Response.
     */
    public static <T> ResponseBean<T> getDefaultInputFailureResponse() {
        ResponseBean<T> response = new ResponseBean<T>();
        response.setCode(ResponseCode.FAILURE.code());
        response.setMessage(ResponseCode.FAILURE.message());
        return response;
    }

    public static <T> ResponseBean<T> getDefaultInputFailureResponse(String msg) {
        ResponseBean<T> response = getDefaultInputFailureResponse();
        response.setMessage(msg);
        return response;
    }
}
