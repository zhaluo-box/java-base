package com.example.learn.pattern.template;

public class H2Model extends HummerModel{
    protected H2Model(String name, boolean isAlarm) {
        super( name, isAlarm );
    }

    protected H2Model(String name) {
        super( name );
    }

    @Override
    protected boolean isAlarm2() {
        return false;
    }

    @Override
    protected void start() {
        System.out.println(this.name +"start!!!!!");
    }

    @Override
    protected void stop() {
        System.out.println(this.name +"stop!!!!!");
    }

    @Override
    protected void alarm() {
        System.out.println(this.name +"honk!!!!!!!!");
    }

    @Override
    protected void engineBoom() {
        System.out.println(this.name +"engineBoom!!!!!");
    }
}
