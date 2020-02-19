package com.canoe.eb.common.entity;

public class ResEntity<T> {
    private int code;
    private String msg;
    private T data;

    private ResEntity(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static <T> ResEntity<T> ok() {
        return new ResEntity<>(200, "", null);
    }

    public static <T> ResEntity<T> ok(String msg) {
        return new ResEntity<>(200, msg, null);
    }

    public static <T> ResEntity<T> ok(T data) {
        return new ResEntity<>(200, "", data);
    }

    public static <T> ResEntity<T> ok(String msg, T data) {
        return new ResEntity<>(200, msg, data);
    }

    public int getCode() {return code;}

    public String getMsg() {return msg;}

    public T getData() {return data;}
}