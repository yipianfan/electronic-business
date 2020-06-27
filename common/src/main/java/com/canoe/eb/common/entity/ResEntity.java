package com.canoe.eb.common.entity;

public class ResEntity<T> {
    public static final int STATUS_OK = 200;
    public static final int STATUS_ERROR = 500;

    private int code;
    private String msg;
    private T data;

    public ResEntity() {}

    private ResEntity(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static <T> ResEntity<T> ok(int code, String msg, T data) {
        return new ResEntity<>(code, msg, data);
    }

    public static <T> ResEntity<T> ok(T data) {
        return new ResEntity<>(STATUS_OK, "", data);
    }

    public static <T> ResEntity<T> error(int code, String msg, T data) {
        return new ResEntity<>(code, msg, data);
    }

    public static <T> ResEntity<T> error() {
        return new ResEntity<>(STATUS_ERROR, "服务忙,请稍后重试", null);
    }

    public static <T> ResEntity<T> error(int code, String msg) {
        return new ResEntity<>(code, msg, null);
    }

    public int getCode() {return code;}

    public String getMsg() {return msg;}

    public T getData() {return data;}
}