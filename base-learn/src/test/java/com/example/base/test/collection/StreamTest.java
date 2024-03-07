package com.example.base.test.collection;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * java stream 相关的一些方法测试
 * Created  on 2024/1/15 14:14:25
 *
 * @author zl
 */
public class StreamTest {

    @Test
    @DisplayName("测试等于指定值放在前面的排序")
    public void testEqualCompare() {
        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(63);
        list.add(2);
        list.add(31);
        list.add(23);
        list.add(1);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(1);
        list.add(12);

        System.out.println(list.stream().sorted(Comparator.comparingInt(i -> i == 2 ? -1 : 1)).collect(Collectors.toList()));
    }

}
