package com.rats.framework.common.base;

import java.io.Serializable;

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

    public String getMsg() {
        return message;
    }

    public void setMsg(String msg) {
        this.message = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}
