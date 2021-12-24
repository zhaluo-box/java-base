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
 * 大对象直接进入老年代
 * -XX:NewSize=10485760 -XX:MaxNewSize=10485760 -XX:InitialHeapSize=20971520 -XX:MaxHeapSize=20971520 -XX:SurvivorRatio=8  -XX:MaxTenuringThreshold=15 -XX:PretenureSizeThreshold=5242880 -XX:+UseParNewGC -XX:+UseConcMarkSweepGC -XX:+PrintGCDetails -XX:+PrintGCTimeStamps -Xloggc:gc-mock-old.log
 */
public class MockOldGC {
    public static void main(String[] args) throws InterruptedException {

        //        test1();
        //        testYear();
        //        mockYearMoreThen15();
        bigObjToOldGen();
    }

    /**
     * 模拟大对象直接进入老年代
     */
    private static void bigObjToOldGen() {
        byte[] array = new byte[7 * 1024 * 1024];
    }

    /**
     * 模拟年龄超过15 进入老年代
     * 新生代,总计10M内存,
     * 8M + 2M + 128k
     */
    private static void mockYearMoreThen15() throws InterruptedException {

        byte[] array2 = new byte[128 * 1024]; // 存活 分配128K数据 被持续引用 动态年龄判断,进入老年代

        for (int i = 0; i < 20; i++) {
            // 分配9M + 800K  释放
            byte[] array1 = new byte[2 * 1024 * 1024];
            array1 = new byte[2 * 1024 * 1024];
            array1 = new byte[2 * 1024 * 1024];
            array1 = new byte[2 * 1024 * 1024];
            array1 = new byte[800 * 1024];
            array1 = null; // 释放引用

            byte[] array3 = new byte[128 * 1024];
            array3 = null;

            Thread.sleep(3000);
            System.out.println("========" + i + "============");
        }

        while (true) {
            Thread.sleep(30000);
        }

    }

    /**
     * 演示年龄
     * 8:1:1
     * 10
     * 年龄1 + 年龄2 + 年龄N > S1区的50*  年龄N以上的直接进入老年代
     */
    private static void testYear() {
        // 分配6M  释放
        byte[] array1 = new byte[2 * 1024 * 1024];
        array1 = new byte[2 * 1024 * 1024];
        array1 = new byte[2 * 1024 * 1024];
        array1 = null; // 释放引用

        byte[] array2 = new byte[128 * 1024]; // 存活 分配128K数据 被持续引用 动态年龄判断,进入老年代

        // 分配6m + 128K 释放
        byte[] array3 = new byte[2 * 1024 * 1024]; // 一次垃圾回收

        array3 = new byte[2 * 1024 * 1024];
        array3 = new byte[2 * 1024 * 1024];
        array3 = new byte[128 * 1024];

        array3 = null; // 释放引用

        byte[] array4 = new byte[2 * 1024 * 1024]; // 存活 第二次垃圾回收 存在于Eden区
    }

    /**
     * 首次测试
     */
    private static void test1() {

        // 先分配6M 内存
        byte[] array1 = new byte[2 * 1024 * 1024];
        array1 = new byte[2 * 1024 * 1024];
        array1 = new byte[2 * 1024 * 1024];

        array1 = null; // 释放引用

        byte[] array2 = new byte[128 * 1024];
        byte[] array3 = new byte[2 * 1024 * 1024];

    }
}
