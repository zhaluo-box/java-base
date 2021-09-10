package com.example.learn.pattern.strategy.demo2.strategy;

/**
 * 先进先出淘汰规则
 * 数据结构上使用队列Queue来实现。
 */
public class FifoEvictionStrategy implements EvictionStrategy {

    @Override
    public void replacement(java.util.Map<?, ?> cacheData) {
        System.out.println( " FIFO : 先进先出规则, 使用队列queue实现 每次访问把user放到队列最后" );
        System.out.println( " FIFO : \n 1. 新访问的数据插入FIFO队列尾部，数据在FIFO队列中顺序移动；\n" +
                "2. 淘汰FIFO队列头部的数据；" );
    }


}
