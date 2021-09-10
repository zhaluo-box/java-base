package com.example.learn.pattern.strategy.demo2;

import com.example.learn.pattern.strategy.demo2.strategy.EvictionStrategy;
import com.example.learn.pattern.strategy.demo2.strategy.EvictionStrategyFactory;

import java.util.Properties;

/**
 * 运行中 根据配置 用户输入 计算结果等不确定因素,动态决定使用哪种策略.
 */
public class Application {

    /**
     * 运行时动态确定，根据配置文件的配置决定使用哪种策略
     */
    public static void main(String[] args) throws Exception {
        // 1. 初始化策略模式.
        EvictionStrategy evictionStrategy = null;
        // 2. 读取配置文件
        Properties props = new Properties();
        //        props.load(new FileInputStream("./config.properties"));
        // 3. 读取配置文件的策略类型
        //        String type = props.getProperty("eviction_type");
        String type = "FIFO";

        // 4. 通过工厂获取具体的策略
        evictionStrategy = EvictionStrategyFactory.getEvictionStrategy(type );
        UserCache userCache = new UserCache( evictionStrategy );
        //...

        userCache.taotai();
    }
}
