package com.astontech.resthr;


import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableCaching
public class CachingConfig {

    //create a cache manager using a concurrent hash map
    @Bean
    public CacheManager cacheManager() {
        return new ConcurrentMapCacheManager("productCache");
    }


}