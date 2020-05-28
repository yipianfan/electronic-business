package com.canoe.eb.account.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class RedisLock {
    @Autowired
    private StringRedisTemplate template;

    public boolean lock(String key, String value) {
        if (template.opsForValue().setIfAbsent(key, value, 120, TimeUnit.SECONDS))
            return true;
        return false;
    }

    public void unlock(String key, String v) {
        if(v.equals(template.opsForValue().get(key)))
            template.opsForValue().getOperations().delete(key);
    }
}