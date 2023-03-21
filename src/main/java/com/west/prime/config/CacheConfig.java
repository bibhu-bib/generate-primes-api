package com.west.prime.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.ZonedDateTime;

@Configuration
@EnableCaching
@EnableScheduling
@Slf4j
public class CacheConfig {
    public static final String CACHE_NAME = "app_cache";

    @Bean
    public CacheManager cacheManager() {
        ConcurrentMapCacheManager cacheManager = new ConcurrentMapCacheManager(CACHE_NAME);
        return cacheManager;
    }

    @CacheEvict(allEntries = true, value = {CACHE_NAME})
    @Scheduled(fixedDelayString = "${cache.ttl.evict}")
    public void evictCache() {
        log.info("Cache evicted! " + ZonedDateTime.now());
    }
}
