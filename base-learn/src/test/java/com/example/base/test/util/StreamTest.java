package com.example.base.test.util;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

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

}
