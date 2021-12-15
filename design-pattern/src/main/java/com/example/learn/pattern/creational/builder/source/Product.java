package com.example.learn.pattern.creational.builder.source;

/**
 * 需要构建的产品类.
 */
public class Product {

    private Object some;
    /**
     * 需要做的事情.
     */
    public void doSomething() {
        //TODO 独立业务处理
    }

    public void setSome(Object some) {
        this.some = some;
    }
}
