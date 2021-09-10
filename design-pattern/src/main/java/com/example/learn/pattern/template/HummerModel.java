package com.example.learn.pattern.template;

public abstract class HummerModel {

    protected String name;

    protected boolean isAlarm = true;

    protected HummerModel(String name, boolean isAlarm) {
        this.name = name;
        this.isAlarm = isAlarm;
    }

    protected HummerModel(String name) {
        this.name = name;
    }

    // 启动
    protected abstract void start();

    // 停止
    protected abstract void stop();

    // 鸣笛
    protected abstract void alarm();

    // 引擎
    protected abstract void engineBoom();

    protected  boolean isAlarm2(){
        return true;
    }

    // 运行
    final protected void run() {
        System.out.println( this.name + "---->" );
        start();
        engineBoom();
        if (isAlarm) {
            alarm();
        }
        stop();
    }

}
