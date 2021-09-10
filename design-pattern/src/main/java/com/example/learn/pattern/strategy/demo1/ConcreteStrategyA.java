package com.example.learn.pattern.strategy.demo1;

/**
 * 策略接口的具体实现.
 */
public class ConcreteStrategyA implements Strategy {

    @Override
    public void algorithmInterface() {
        System.out.println("策略接口 实现1");
    }
}
