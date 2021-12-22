package com.example.learn.pattern.behavior.observe.chapter2;

import com.example.learn.pattern.behavior.observe.chapter2.annoition.Subscribe;

/**
 *
 */
public class ObserverOne {

    @Subscribe
    public void handle(AMsg msg) {
        System.out.println("观察者1 方法1" + msg);
    }

    @Subscribe
    public void send(AMsg msg) {
        System.out.println("观察者1 方法2" + msg);
    }
}
