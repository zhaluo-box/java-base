package com.example.base.test.math;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.math.BigDecimal;

/**
 * Created  on 2022/8/31 15:15:03
 *
 * @author zl
 */
public class BigDecimalTest {

    @Test
    @DisplayName("bigDecimal add method test")
    public void testAdd() {
        var result = BigDecimal.ZERO;
        try {
            System.out.println(result.add(null));
        } catch (NullPointerException exception) {
            System.out.println("bigDecimal 加法 被加的数字不能为null");
        }
    }
}
