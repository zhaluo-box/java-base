package com.example.common.jvm.learn.chaper01;

/**
 * 模拟young GC
 * JVM 参数模板  基于ＪＤＫ８
 * 查看项目下的gc.log
 * -XX:NewSize=5242880 -XX:MaxNewSize=5242880 -XX:InitialHeapSize=10485760 -XX:MaxHeapSize=10485760 -XX:SurvivorRatio=8 -XX:PretenureSizeThreshold=10485760 -XX:+UseParNewGC -XX:+UseConcMarkSweepGC -XX:+PrintGCDetails -XX:+PrintGCTimeStamps -Xloggc:gc-mock-young.log
 * 初始与最大堆大小 10M, 新生代初始与最大大小都是5M,
 * PretenureSizeThreshold 大对象阈值 10M
 * SurvivorRatio Eden 区域占用的大小比例为8 总计10, 所以两个s区为 1  8:1:1
 */
public class MockYoungGC {

    public static void main(String[] args) {

        int i = 0;
        while (i < 20) {
            try {
                System.out.println("开始模拟young GC ");
                // 连续分配4个数组,内存为1M
                byte[] arrayData = new byte[1024 * 1024];
                arrayData = new byte[1024 * 1024];
                arrayData = new byte[1024 * 1024];
                arrayData = null;// 移除引用

                byte[] array2 = new byte[1024 * 1024 * 2];
                System.out.println("结束模拟young GC ");
                Thread.sleep(30000l);
                i++;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
