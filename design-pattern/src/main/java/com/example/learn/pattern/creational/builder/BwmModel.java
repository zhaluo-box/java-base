package com.example.learn.pattern.creational.builder;

import java.util.List;

public class BwmModel extends CarModel {

    public BwmModel(List<String> sequence, String name) {
        super( sequence, name );
    }

    public BwmModel(String name) {
        super( name );
    }


    @Override
    protected void start() {
        System.out.println( super.name + "启动了" );
    }

    @Override
    protected void stop() {
        System.out.println( super.name + "熄火停车" );
    }

    @Override
    protected void alarm() {
        System.out.println( super.name + "鸣笛!" );
    }

    @Override
    protected void engineBoom() {
        System.out.println( super.name + "发动了引擎!" );
    }
}
