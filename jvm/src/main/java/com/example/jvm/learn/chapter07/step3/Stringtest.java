package com.example.jvm.learn.chapter07.step3;

public class Stringtest {
    public static void main(String[] args) {
        String name = "zhishudali.com";
        final int i = name.indexOf( "." );
        System.out.println(i);
    }
}
