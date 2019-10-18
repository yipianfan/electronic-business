package com.canoe.eb.account.config;

import com.alibaba.fastjson.JSONObject;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

@Component
@Aspect
public class LogAspect {
    private final Logger logger = LoggerFactory.getLogger(LogAspect.class);

    @Pointcut("execution(public * com.canoe.eb.account.controller.*.*(..))")
    private void log() {}

    @Before("log()")
    public void doBefore(JoinPoint joinPoint) {
        ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = sra.getRequest();

        MethodSignature mSignature = (MethodSignature) joinPoint.getSignature();
        Method method = mSignature.getMethod();

        Map<String, Object> map = getParameter(method, joinPoint.getArgs(), request);
        map.put("uri", request.getRequestURI());

        logger.info(JSONObject.toJSONString(map));
    }

    private Map<String, Object> getParameter(Method method, Object[] args, HttpServletRequest request) {
        Parameter[] parameters = method.getParameters();
        Enumeration<String> names = request.getParameterNames();

        Map<String, Object> map = new HashMap<>();
        while(names.hasMoreElements()) {
            String n = names.nextElement();
            map.put(n, request.getParameter(n));
        }

        for (int i = 0;i < parameters.length;i++) {
            RequestBody rb = parameters[i].getAnnotation(RequestBody.class);
            if(rb != null) {
                @SuppressWarnings("unchecked")
                Map<String, Object> dtoMap = (Map<String, Object>)JSONObject.toJSON(args[i]);
                map.putAll(dtoMap);
                continue;
            }
            RequestHeader rh = parameters[i].getAnnotation(RequestHeader.class);
            if(rh != null) {
                map.put(parameters[i].getName(), args[i]);
                continue;
            }
            PathVariable pv = parameters[i].getAnnotation(PathVariable.class);
            if(pv != null) {
                map.put(parameters[i].getName(), args[i]);
                continue;
            }
        }
        return map;
    }
}