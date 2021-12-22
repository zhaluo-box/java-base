package com.example.learn.pattern.behavior.observe.chapter1;

import com.example.learn.pattern.behavior.observe.chapter1.inteface.Observer;

/**
 *
 */
public class ConcreteObserverOne implements Observer {

    @Override
    public void update(Message message) {
        System.out.println("观察者1 : " + message);
    }
}
