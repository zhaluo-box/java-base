package com.example.learn.pattern.creational.single.impl;

/**
 * 懒汉
 * 全局加锁, 性能较差
 */
public class Lazybones {

    private static Lazybones instance;

    private Lazybones() {
    }

    public static synchronized Lazybones getInstance() {
        if (instance == null) {
            instance = new Lazybones();
        }
        return instance;
    }
}
