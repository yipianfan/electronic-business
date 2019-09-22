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

    public static <T> ResEntity<T> ok(T data) {return new ResEntity<>(200, "ok", data);}

    public static <T> ResEntity<T> r404() {return new ResEntity<>(404, "已逃离地球", null);}

    public static <T> ResEntity<T> result(String msg) {return new ResEntity<>(400, msg, null);}

    public int getCode() {return code;}

    public String getMsg() {return msg;}

    public T getData() {return data;}
}