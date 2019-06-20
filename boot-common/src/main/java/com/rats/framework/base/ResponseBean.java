package com.rats.framework.base;

import java.io.Serializable;

/**
 *
 * @author hanbing
 * @since 1.0.0
 * @date 2019-06-20
 */
public class ResponseBean<T> implements Serializable {

    public static final int SUCCESS = 0;
    public static final int FAIL = -1;
    public static final  String RESULT_SUCCESS = "success";
    public static final  String RESULT_FAILED = "failed";

    private int code;
    private String message;
    private T data;

    public ResponseBean() {
        super();
    }

    public ResponseBean(T data) {
        super();
        this.data = data;
    }

    public ResponseBean(Throwable e) {
        super();
        this.message = e.getMessage();
        this.code = FAIL;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
