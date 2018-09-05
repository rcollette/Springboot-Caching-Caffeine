package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@CacheConfig(cacheNames = "cache1", cacheManager = "cache1")
public class Service1 implements ValueGetter {

    @Cacheable(unless = "#result == null")
    public Integer getValue(Integer value) {
        log.info("Service1 GetValue {}", value);
        return value;
    }
}
