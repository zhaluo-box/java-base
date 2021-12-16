package com.example.common.jvm.learn.chapter02;

import java.util.ArrayList;
import java.util.List;

/**
 * 运行时常量池溢出
 *
 * VM Arg: -XX:PermSize=10M -XX:MaxPermSize=10M
 *
 * @author 扎罗
 */
public class RuntimeConstantPoolOOM {

    public static void main(String[] args) {
       // stringIntern();
    }

    private static void stringIntern() {
        List<String> list = new ArrayList<>();
        int i = 0;
        while (true) {
            list.add(String.valueOf(i++).intern());
        }
    }
}
