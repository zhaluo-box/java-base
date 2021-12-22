package com.example.learn.pattern.creational.factory.entity;

/**
 *
 */
public class DELLMouse implements Mouse {

    @Override
    public String getName() {
        return "戴尔";
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