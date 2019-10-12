package com.canoe.eb.account.config;

import com.alibaba.fastjson.JSONObject;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Component
@Aspect
public class LogAspect {

    @Pointcut("execution(public * com.canoe.eb.account.controller.*.*(..))")
    private void log() {}

    @Before("log()")
    public void doBefore() {
        ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = sra.getRequest();
        Map<String, String[]> parameter = request.getParameterMap();

        String log = JSONObject.toJSONString(parameter);
        System.out.println(log);
    }
}