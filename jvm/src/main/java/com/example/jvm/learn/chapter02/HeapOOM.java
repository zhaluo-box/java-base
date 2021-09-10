package com.example.jvm.learn.chapter02;

import java.util.ArrayList;
import java.util.List;

/**
 * JVM 参数:  -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 *
 * 演示 内存溢出
 */
public class HeapOOM {

    static class OOMObject {

    }

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<>();

        while (true){
            list.add(new OOMObject());
        }
    }
}
