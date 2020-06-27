package com.canoe.eb.account.controller;

import com.canoe.eb.account.ex.BusinessException;
import com.canoe.eb.common.entity.ResEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static com.canoe.eb.common.entity.ResEntity.ok;

@RestControllerAdvice
public class AccountExHandler {

    @ExceptionHandler(BusinessException.class)
    public ResEntity<String> businessException(BusinessException ex) {
        return ok(ResEntity.STATUS_OK, ex.getMessage(), null);
    }
}