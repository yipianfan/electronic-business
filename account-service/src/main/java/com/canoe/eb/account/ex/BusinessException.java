package com.canoe.eb.account.ex;

public class BusinessException extends RuntimeException {

    public BusinessException(String msg) {
        super(msg);
    }
}