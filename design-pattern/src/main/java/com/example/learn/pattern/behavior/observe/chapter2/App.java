package com.example.learn.pattern.behavior.observe.chapter2;

import java.util.concurrent.Executors;

/**
 *
 */
public class App {

    public static void main(String[] args) {
        var eventBus = new EventBus();

        var observerOne = new ObserverOne();
        var observerTwo = new ObserverTwo();

        var aMsg = new AMsg("A 消息");
        var bMsg = new BMsg("B 消息");
        //        eventBus.register(observerOne);
        //        eventBus.register(observerTwo);
        //
        //        eventBus.post(aMsg);
        //        eventBus.post(bMsg);

        System.out.println("------异步适配器-----------");
        var asyncEventBus = new AsyncEventBus(Executors.newFixedThreadPool(2));

        asyncEventBus.register(observerOne);
        asyncEventBus.register(observerTwo);

        asyncEventBus.post(aMsg);
        asyncEventBus.post(bMsg);

    }
}
