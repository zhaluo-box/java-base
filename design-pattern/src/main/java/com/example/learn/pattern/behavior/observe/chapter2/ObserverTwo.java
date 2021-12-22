package com.example.learn.pattern.behavior.observe.chapter2;

import com.example.learn.pattern.behavior.observe.chapter2.annoition.Subscribe;

/**
 *
 */
public class ObserverTwo {

    @Subscribe
    public void handle(BMsg msg) {
        System.out.println("观察者2 方法1" + msg);
    }

    @Subscribe
    public void send(BMsg msg) {
        System.out.println("观察者2 方法2" + msg);
    }
}
