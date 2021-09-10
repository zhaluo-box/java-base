package com.example.learn.pattern.strategy.demo2;



import com.example.learn.pattern.strategy.demo2.strategy.EvictionStrategy;

import java.util.HashMap;
import java.util.Map;

/**
 * // 策略接口：EvictionStrategy
 * // 策略类：LruEvictionStrategy、FifoEvictionStrategy、LfuEvictionStrategy...
 * // 策略工厂：EvictionStrategyFactory
 */
public class UserCache {

    private Map<String, User> cacheData = new HashMap<>();

    private EvictionStrategy eviction;

    /**
     * 构造器传入策略.
     *
     * @param eviction
     */
    public UserCache(EvictionStrategy eviction) {
        this.eviction = eviction;
    }


    /**
     * 淘汰方法.
     */
    public void taotai() {
        // 本质调用淘汰策略的接口
        eviction.replacement( cacheData );
    }

}
