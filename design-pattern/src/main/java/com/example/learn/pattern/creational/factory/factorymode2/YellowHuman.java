package com.example.learn.pattern.creational.factory.factorymode2;

/**
 * 定义黄种人, 实现human
 */
public class YellowHuman implements Human{

    @Override
    public void laugh() {
        System.out.println("普通的生活就让黄种人感觉很幸福");
    }

    @Override
    public void cry() {
        System.out.println("黄种人 也有悲欢离合");
    }

    @Override
    public void talk() {
        System.out.println("黄种人讲话很谦虚");
    }
}
