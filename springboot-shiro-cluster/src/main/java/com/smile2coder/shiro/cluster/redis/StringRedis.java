package com.smile2coder.shiro.cluster.redis;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Set;

/**
 * @author ZxT
 * @date 2020-06-07
 * @desc
 */
@Component
public class StringRedis {

    @Autowired
    private RedisTemplate<Serializable, Object> redisTemplate;


    public void set(Serializable key, Object value) {
        this.redisTemplate.opsForValue().set(key, value);
    }

    public Object get(Serializable key) {
        return this.redisTemplate.opsForValue().get(key);
    }

    public void delete(Serializable key) {
        this.redisTemplate.delete(key);
    }

    public Set<Serializable> scan(Serializable pattern) {
        return this.redisTemplate.keys(pattern);
    }

}
