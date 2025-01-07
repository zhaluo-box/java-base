package com.example.base.test.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * java 8 流测试
 * Created  on 2023/4/6 13:13:42
 *
 * @author zl
 */
public class StreamTest {

    private List<Integer> data = List.of(1, 2, 3, 4, 5, 6);

    @Test
    @DisplayName("流测试")
    public void streamIfTest() {

        int x = 5;
        var stream = data.stream();
        Stream<Integer> newStream = stream;
        if (x > 2) {
            newStream = stream.filter(i -> i > 2);
        }
        newStream.forEach(System.out::println);
        stream.close();
    }

    @Test
    @DisplayName("测试 match")
    public void matchTest() {
        List<Boolean> booleans = new ArrayList<>();
        //        booleans.add(true);
        //        booleans.add(true);
        //                booleans.add(false);
        //        boolean allMatch = booleans.stream().allMatch(Boolean::booleanValue);
        boolean allMatch = booleans.stream().allMatch(x -> x);
        System.out.println("allMatch = " + allMatch);
        boolean anyMatch = booleans.stream().anyMatch(x -> x);
        System.out.println("anyMatch = " + anyMatch);
        // 如果流中没有元素与提供的谓词匹配或流为空，则为true，否则为false
        boolean noneMatch = booleans.stream().noneMatch(x -> !x);
        System.out.println("noneMatch = " + noneMatch);

    }

}
