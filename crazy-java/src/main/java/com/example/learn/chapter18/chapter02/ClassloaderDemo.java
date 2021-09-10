package com.zhaluobox.crazyjava.第18章类加载机制与反射.chapter18_02_类加载器;

public class ClassloaderDemo {

    public static void main(String[] args) {
        System.out.println(System.getProperty("java.ext.dirs"));
        ClassLoader cl = Hello.class.getClassLoader();
        System.out.println(cl.toString());
        System.out.println(cl.getParent().toString());
        System.out.println(cl.getParent().getParent());
        System.out.println(int.class.getClassLoader()); // null 代表是从bootstrap 类加载器加载的
    }
}
