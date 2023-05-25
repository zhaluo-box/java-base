package com.example.learn.pattern.behavioral.template;

public class H1Model extends HummerModel {

    public H1Model(String name) {
        super(name);
    }

    @Override
    protected void start() {
        System.out.println("H1 start!");

    }

    @Override
    protected void stop() {
        System.out.println("H1 stop!");
    }

    @Override
    protected void alarm() {

        System.out.println("H1 honk");

    }

    @Override
    protected void engineBoom() {
        System.out.println("H1 engine!");
    }
}
