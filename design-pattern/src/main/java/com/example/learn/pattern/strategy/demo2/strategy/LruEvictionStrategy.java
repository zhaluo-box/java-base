package com.example.learn.pattern.strategy.demo2.strategy;

/**
 * 算法根据数据的历史访问记录来进行淘汰数据，其核心思想是“如果数据最近被访问过，那么将来被访问的几率也更高”。
 * 最常见的实现是使用一个链表保存缓存数据，详细算法实现如下：
 * 1. 新数据插入到链表头部；
 * 2. 每当缓存命中（即缓存数据被访问），则将数据移到链表头部；
 * 3. 当链表满的时候，将链表尾部的数据丢弃。
 */
public class LruEvictionStrategy implements EvictionStrategy {


    @Override
    public void replacement(java.util.Map<?, ?> cacheData) {
        System.out.println( "LRU :  *算法根据数据的历史访问记录来进行淘汰数据，其核心思想是“如果数据最近被访问过，那么将来被访问的几率也更高”。\n" +
                " * 最常见的实现是使用一个链表保存缓存数据，详细算法实现如下：\n" +
                " * 1. 新数据插入到链表头部；\n" +
                " * 2. 每当缓存命中（即缓存数据被访问），则将数据移到链表头部；\n" +
                " * 3. 当链表满的时候，将链表尾部的数据丢弃。" );
    }
}
