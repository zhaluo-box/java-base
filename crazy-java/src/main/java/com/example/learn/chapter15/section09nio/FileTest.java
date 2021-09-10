package com.zhaluobox.crazyjava.chapter15.section09nio;

public class FileTest {
    public static void main(String[] args) {
        System.out.println(FileChannelTest.class.getResource("/"));
        System.out.println(FileChannelTest.class.getResource(""));
        System.out.println(ClassLoader.getSystemResource(""));
        System.out.println(ClassLoader.getSystemResource("/"));
        System.out.println(ClassLoader.getSystemResource("/"));
    }
}
