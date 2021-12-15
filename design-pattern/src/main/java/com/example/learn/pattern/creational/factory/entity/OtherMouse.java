package com.example.learn.pattern.creational.factory.entity;

/**
 *
 */
public class OtherMouse implements Mouse {
    @Override
    public String getName() {
        return "其他";
    }

    @Override
    public void click() {
        System.out.println(getName() + print(ClickType.SINGLE));
    }

    @Override
    public void doubleClick() {
        System.out.println(getName() + print(ClickType.DOUBLE));
    }
}
