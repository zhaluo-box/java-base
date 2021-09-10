package com.example.learn.pattern.strategy.demo2.strategy;

import java.util.HashMap;
import java.util.Map;

/**
 * 缓存淘汰策略工厂
 */
public class EvictionStrategyFactory {

    // 池化 new HashMap<String,Object>();
    public static final Map<String, EvictionStrategy> pool = new HashMap<>( 16 );


    // 初始化池. 也可以通过构造器的方式 初始化
    static {
        pool.put( "LFU", new LfuEvictionStrategy() );
        pool.put( "LRU", new LruEvictionStrategy() );
        pool.put( "FIFO", new FifoEvictionStrategy() );
    }


    public static EvictionStrategy getEvictionStrategy(String type) {
        if (null == type || "".equals( type ))
            throw new IllegalArgumentException( "策略类型不能为空 !" );
        return pool.get( type );
    }


}
