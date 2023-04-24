package com.example.base.test.lang;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Created  on 2023/4/20 15:15:05
 *
 * @author zl
 */

public class IntegerTest {

    @Test
    @DisplayName("测试Integer 最大值与最小值")
    public void maxAndMin() {

        System.out.println("Integer.MAX_VALUE = " + Integer.MAX_VALUE);
        System.out.println("Integer.MIN_VALUE = " + Integer.MIN_VALUE);
    }

}
