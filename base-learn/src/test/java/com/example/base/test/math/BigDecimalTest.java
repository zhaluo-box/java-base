package com.example.base.test.math;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.math.BigDecimal;
import java.math.RoundingMode;

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

    @Test
    @DisplayName("bigDecimal 减法")
    public void testSubtract() {
        var bigDecimal = new BigDecimal("12.22");
        var result = bigDecimal.subtract(new BigDecimal("1.1"));
        System.out.println(result);
    }

    @Test
    @DisplayName("bigDecimal 除法, 需要指定小数位，否则会有无穷小数的异常！")
    public void testDivide() {
        var bigDecimal = new BigDecimal("12.22");
        var result = bigDecimal.divide(new BigDecimal("1.1"), 3, RoundingMode.DOWN);
        System.out.println(result);
    }

    @Test
    @DisplayName("bigDecimal 乘法")
    public void testMultiply() {
        var bigDecimal = new BigDecimal("12.22");
        var result = bigDecimal.multiply(new BigDecimal("1.1"));
        System.out.println(result);
    }

}
