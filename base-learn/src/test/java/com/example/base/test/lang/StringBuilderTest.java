package com.example.base.test.lang;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Created  on 2023/10/16 14:14:34
 *
 * @author zl
 */
public class StringBuilderTest {

    @Test
    @DisplayName("测试append")
    public void testAppend() {
        StringBuilder sb = new StringBuilder();
        var string = sb.append("name").append("age").append(12).toString();

        System.out.println("string = " + string);
    }
}
