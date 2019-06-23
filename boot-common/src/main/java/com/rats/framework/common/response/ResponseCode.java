package com.rats.framework.common.response;

public enum ResponseCode {

    SUCCESS(0, "success"),
    FAILURE(1000, "failure"),
    ERROR(-1, "error");

    private Integer code;
    private String message;

    ResponseCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer code() {
        return this.code;
    }

    public String message() {
        return this.message;
    }

}
