package com.example.learn.pattern.builder;

import java.util.List;

/**
 * 奔驰模型!
 */
public class BenzModel extends CarModel {


    public BenzModel(List<String> sequence, String name) {
        super( sequence, name );
    }

    public BenzModel(String name) {
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
