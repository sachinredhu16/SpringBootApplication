package com.school.Redis.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class CacheController {

    @Autowired
    private CacheManager cacheManager;

    @GetMapping("/cache-stats")
    public Map<String, String> getCacheStats() {
        Map<String, String> cacheStats = new HashMap<>();
        for (String cacheName : cacheManager.getCacheNames()) {
            Cache cache = cacheManager.getCache(cacheName);
            if (cache != null) {
                cacheStats.put(cacheName, cache.getNativeCache().toString());
            }
        }
        return cacheStats;
    }
}
