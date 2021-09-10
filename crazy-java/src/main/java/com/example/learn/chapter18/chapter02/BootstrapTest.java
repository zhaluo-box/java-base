//package com.example.learn.chapter18.chapter02;
//
//import sun.misc.Launcher;
//
//import java.net.*;
//import java.util.Arrays;
//import java.util.Properties;
//
///**
// * Description: 引导类加载器
// * <br/>网站: <a href="http://www.crazyit.org">疯狂Java联盟</a>
// * <br/>Copyright (C), 2001-2016, Yeeku.H.Lee
// * <br/>This program is protected by copyright laws.
// * <br/>Program Name:
// * <br/>Date:
// *
// * @author Yeeku.H.Lee kongyeeku@163.com
// * @version 1.0
// */
//public class BootstrapTest {
//    public static void main(String[] args) {
//        Properties properties = System.getProperties();
//        properties.forEach((k, v) -> System.out.println(k + "   :   " + v));
//
//        System.out.println("------------------------------------------------------------");
//        System.out.println(System.getProperty("sun.boot.class.path"));
//        // 获取根类加载器所加载的全部URL数组
//        URL[] urls = sun.misc.Launcher.getBootstrapClassPath().getURLs();
//        ClassLoader classLoader = Launcher.getLauncher().getClassLoader();
//        ClassLoader parent = classLoader.getParent();
//        // 遍历、输出根类加载器加载的全部URL
//        Arrays.stream(urls).forEach(c -> {
//            System.out.println(c.toExternalForm());
//        });
//    }
//}
//
