package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@CacheConfig(cacheNames = "cache2", cacheManager = "cache2")
public class Service2 implements ValueGetter {

    @Cacheable
    public Integer getValue(Integer value) {
        log.info("Service2 GetValue {}", value);
        return value;
    }
}
