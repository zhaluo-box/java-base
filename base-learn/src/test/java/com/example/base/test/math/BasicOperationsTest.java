package com.example.base.test.math;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Created  on 2024-7-26 10:10:48
 *
 * @author zl
 */
public class BasicOperationsTest {

    @DisplayName("乘法测试")
    @Test
    public void multiplicationTest() {
        int x = 2 * 100;
        System.out.println("x = " + x);
    }
}
