package com.example.demo;

import java.util.stream.IntStream;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.Cache;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCacheManager;

@SpringBootApplication
@EnableCaching
@Slf4j
public class DemoApplication implements CommandLineRunner {

    private ValueGetter service1;
    private ValueGetter service2;
    private ValueGetter service3;

    private CaffeineCacheManager cacheManager1;
    private CaffeineCacheManager cacheManager2;

    public DemoApplication(ValueGetter service1,
                           ValueGetter service2,
                           ValueGetter service3,
                           CaffeineCacheManager cache1,
                           CaffeineCacheManager cache2) {
        this.service1 = service1;
        this.service2 = service2;
        this.service3 = service3;
        this.cacheManager1 =cache1;
        this.cacheManager2 =cache2;
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... args) {
        exercise();
        log.info("******Second calls*****");
        Cache cache1 = cacheManager1.getCache("cache1");
        exercise();
    }

    private void exercise() {
        IntStream.range(1, 11).forEachOrdered(i -> GetValue(service1, 1, i));
        GetValue(service1, 1, null);
        IntStream.range(1, 11).forEachOrdered(i -> GetValue(service2, 2, i));
        GetValue(service2, 2, null);
        IntStream.range(1, 11).forEachOrdered(i -> GetValue(service3, 3, i));
        GetValue(service3, 3, null);
    }

    private static void GetValue(ValueGetter service, int num, Integer value) {
        Integer got = service.getValue(value);
        log.info("got from service {}: {}", num, got);
    }
}
