package com.example.learn.pattern.strategy.sgg.improve;

public class WildDuck extends Duck {


    /**
     * 构造器传入行为策略
     */
    //构造器，传入FlyBehavor 的对象
    public WildDuck() {
        // TODO Auto-generated constructor stub
        flyBehavior = new GoodFlyBehavior();
    }


    @Override
    public void display() {
        // TODO Auto-generated method stub
        System.out.println( " 这是野鸭 " );
    }

}

// 1. 定义一种行为策略接口
// 2. 多个具体的行为策略实现
// 3. 定义一种 抽象的 事物
// 4.
