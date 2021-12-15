package com.example.learn.pattern.creational.single.impl;

/**
 * 饿汉,
 * 优点: 对于一些创建比较耗时的实例对象,推荐使用这种,可以在系统加载的时候创建, 提高客户的首次点击体验.
 * 缺点: 不支持延时加载
 */
public class HungerSingle {

    private static final HungerSingle instance = new HungerSingle();

    private HungerSingle() {

    }

    public static HungerSingle getInstance() {
        return instance;
    }
}
