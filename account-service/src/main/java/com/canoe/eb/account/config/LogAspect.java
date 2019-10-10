package com.canoe.eb.account.config;

import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogAspect {

    @Around("")
    public Object aroundAdvice() {

    }
}