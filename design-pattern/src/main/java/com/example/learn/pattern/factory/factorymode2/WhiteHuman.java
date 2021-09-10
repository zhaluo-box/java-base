package com.example.learn.pattern.factory.factorymode2;

/**
 * 白人
 */
public class WhiteHuman implements Human {

    @Override
    public void laugh() {
        System.out.println("白人会哈哈大笑.");
    }

    @Override
    public void cry() {
        System.out.println("白人也会哭");
    }

    @Override
    public void talk() {
        System.out.println("白人讲话很绅士");
    }
}
