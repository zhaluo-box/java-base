package com.example.learn.pattern.behavior.observe.chapter1;

/**
 * 简单观察者模式
 */
public class ObserveApp {

    public static void main(String[] args) {

        var concreteObserverOne = new ConcreteObserverOne();
        var concreteObserverTwo = new ConcreteObserverTwo();

        // 注册 观察者
        var concreteSubject = new ConcreteSubject();
        concreteSubject.registerObserver(concreteObserverOne);
        concreteSubject.registerObserver(concreteObserverTwo);

        // 通知消息
        var msg = new Message<String>().setData("数据").setInfo("消息");
        concreteSubject.noticeObserver(msg);

        // 移除观察者
        concreteSubject.removeObserver(concreteObserverOne);
        concreteSubject.noticeObserver(msg);

    }

}
