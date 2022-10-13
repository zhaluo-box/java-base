package com.example.base.test.lang;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.ArrayList;

/**
 * Created  on 2022/9/29 16:16:28
 *
 * @author zl
 */
public class StringTest {

    @Test
    @DisplayName("String format 测试 format == 测试事件1 【 %s 】 【 %s 】")
    public void formatTest() {

        var objects = new ArrayList<>();
        objects.add("name");
        objects.add("11");

        var s = String.format("测试事件1 【 %s 】 【 %s 】", objects.toArray());
        System.out.println(s);
    }
}
