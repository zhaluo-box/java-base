package com.example.common.jvm.learn.chaper01;

/**
 * JDK 8
 * 模拟触发进入老年代,触发老年代GC
 * 堆内存 分配 Eden 8M  S-form 1M  S-to 1M
 * 老年代 10M
 * 大于10M的对象直接进入老年代
 * 动态年龄判断15岁
 * JVM 参数
 * -XX:NewSize=10485760 -XX:MaxNewSize=10485760 -XX:InitialHeapSize=20971520 -XX:MaxHeapSize=20971520 -XX:SurvivorRatio=8  -XX:MaxTenuringThreshold=15 -XX:PretenureSizeThreshold=10485760 -XX:+UseParNewGC -XX:+UseConcMarkSweepGC -XX:+PrintGCDetails -XX:+PrintGCTimeStamps -Xloggc:gc-mock-old.log
 */
public class MockOldGC {
    public static void main(String[] args) {

        // 先分配8M 内存
        byte[] array1 = new byte[2 * 1024 * 1024];
        array1 = new byte[2 * 1024 * 1024];
        array1 = new byte[2 * 1024 * 1024];

        array1 = null;

        byte[] array2 = new byte[128 * 1024];
        byte[] array3 = new byte[2 * 1024 * 1024];

    }
}
