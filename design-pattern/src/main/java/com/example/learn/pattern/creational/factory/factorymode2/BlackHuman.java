package com.example.learn.pattern.creational.factory.factorymode2;

/**
 * 黑人
 */
public class BlackHuman implements Human {

    @Override
    public void laugh() {
        System.out.println("黑人笑起来牙齿很白");
    }

    @Override
    public void cry() {
        System.out.println("黑人哭起来很逗比,很表情包");
    }

    @Override
    public void talk() {
        System.out.println("黑人会饶舌,还很6");
    }
}
