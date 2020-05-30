package com.epam.randomWalk.cache;

import com.epam.randomWalk.walk.walkDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

@Service("cacheService")
public class cacheService {
    private static final Logger log = LoggerFactory.getLogger(cacheService.class);
    private HashMap<walkDto, Long> cache = new HashMap<>();

    public cacheService() {}

    public void add(walkDto walks, long randomNum) {
        log.info("Adding new values to cache");
        cache.put(walks, randomNum);
    }

    public boolean contains(walkDto walks) {
        log.info("Check if contains in cache");
        return cache.containsKey(walks);
    }

    public long getResults(walkDto walks) {
        log.info("Getting results from cache");
        return cache.get(walks);
    }

    public void updateValue(walkDto walks, long newValue) {
        log.info("Update results");
        cache.remove(walks);
        cache.put(walks, newValue);
    }

    public HashMap<walkDto, Long> getCache() {
        return cache;
    }
}