package com.example.learn.pattern.behavior.observe.chapter1;

import com.example.learn.pattern.behavior.observe.chapter1.inteface.Observer;
import com.example.learn.pattern.behavior.observe.chapter1.inteface.Subject;

import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * 被观察者
 */
public class ConcreteSubject implements Subject {

    // 定义一个容器存放所有的观察者
    private static final Set<Observer> OBSERVERS = new CopyOnWriteArraySet<>();

    @Override
    public void registerObserver(Observer observer) {
        OBSERVERS.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        OBSERVERS.remove(observer);
    }

    @Override
    public void noticeObserver(Message message) {
        OBSERVERS.forEach(observer -> observer.update(message));
    }
}
