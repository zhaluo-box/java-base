package com.example.juc.learn.exercise.cas;


public class Accent {

    public static void main(String[] args) {
        System.out.println(Constant.status.get()); //true
        Constant.status.set(false);
        System.out.println(Constant.status.get()); //false

        var accxed = new Accxed();
        accxed.setValue(true);
        System.out.println(Constant.status.get()); //true
    }
}
