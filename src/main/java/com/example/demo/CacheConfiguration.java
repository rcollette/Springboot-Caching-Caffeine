package com.example.demo;

import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class CacheConfiguration extends CachingConfigurerSupport {

    @Bean
    @Primary
    public CaffeineCacheManager cache1() {
        CaffeineCacheManager cacheManager = new CaffeineCacheManager("cache1");
        cacheManager.setAllowNullValues(false);
        Caffeine<Object, Object> builder = Caffeine.newBuilder();
        cacheManager.setCaffeine(builder);
        return cacheManager;
    }

    @Bean
    public CaffeineCacheManager cache2() {
        CaffeineCacheManager cacheManager = new CaffeineCacheManager("cache2", "cache3");
        cacheManager.setAllowNullValues(true);
        Caffeine<Object, Object> builder = Caffeine.newBuilder()
                .maximumSize(10);
        cacheManager.setCaffeine(builder);
        return cacheManager;
    }


}
