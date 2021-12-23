package com.example.test.stream;

import org.junit.Test;

import java.util.ArrayList;

public class StreamTest {

    @Test
    public void testStreamEndOperation() {
        var list = new ArrayList<String>();

        for (int i = 0; i < 10; i++) {
            list.add(String.valueOf(i));
        }
        var sorted = list.stream().mapToInt(Integer::valueOf).sorted();
        var reduce = sorted.filter(x -> x > 5).reduce(Integer::sum);

        if (reduce.isPresent()) {
            System.out.println(reduce.getAsInt());
        }

    }

    @Test
    public void midStreamTest() {

        var list = new ArrayList<String>();

        for (int i = 0; i < 10; i++) {
            list.add(String.valueOf(i));
        }
        var sorted = list.stream().mapToInt(Integer::valueOf).sorted();

        sorted.forEach(System.out::println);

        System.out.println("第二次打印!============================");

        try {
            sorted.forEach(System.out::println);
        } catch (IllegalStateException e) {
            System.out.println("异常信息" + e.getMessage());
            System.out.println("流一旦被归约节点使用,就无法再次使用");
        }

    }

}
