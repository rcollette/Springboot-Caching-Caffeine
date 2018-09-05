package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class Service3 implements ValueGetter {

    //You can somewhat avoid magic strings with a custom annotation, but usage may be low anyway.
    @Cache3
    public Integer getValue(Integer value) {
        log.info("Service3 GetValue {}", value);
        if (value == null) return null;
        return value + 20;
    }
}
