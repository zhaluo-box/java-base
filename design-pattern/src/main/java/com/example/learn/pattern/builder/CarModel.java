package com.example.learn.pattern.builder;

import java.util.ArrayList;
import java.util.List;

/**
 * 汽车模型模板.
 */
public abstract class CarModel {

    private List<String> sequence = new ArrayList<>();

    public CarModel(List<String> sequence, String name) {
        this.sequence = sequence;
        this.name = name;
    }

    public CarModel( String name) {
        this.name = name;
    }

    // 名称.
    protected String name;

    // 启动
    protected abstract void start();

    // 停止
    protected abstract void stop();

    // 鸣笛
    protected abstract void alarm();

    // 引擎
    protected abstract void engineBoom();

    // 运行
    public final void run() {
        for (final String actionName : sequence) {
            if (actionName.equalsIgnoreCase( "start" )) {
                this.start(); //启动汽车
            } else if (actionName.equalsIgnoreCase( "stop" )) {
                this.stop(); //停止汽车
            } else if (actionName.equalsIgnoreCase( "alarm" )) {
                this.alarm(); //喇叭开始叫了
            } else if (actionName.equalsIgnoreCase( "engine boom" )) { //如果是engine boom关键字
                this.engineBoom(); //引擎开始轰鸣
            }
        }
    }

    // 设定启动顺序.
     public final void setSequence(List<String> sequence) {
        this.sequence = sequence;
    }
}
