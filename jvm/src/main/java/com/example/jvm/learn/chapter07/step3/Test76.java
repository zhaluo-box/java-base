package com.example.jvm.learn.chapter07.step3;

public class Test76 {

    static class Parent {
        public static int A = 100;

        static {
            A = A * 2;
        }
    }

    static class Child extends Parent{
        public static int B = A; // B =A 冗(rong)余
        static {
            B = 101;
        }
    }

    public static void main(String[] args) {
        System.out.println(Child.B);
    }
}
