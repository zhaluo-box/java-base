package com.example.base.test.math;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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

    @Test
    @DisplayName("scale method test")
    public void testScale() {
        var data = new BigDecimal("10000.12209202029");
        System.out.println(data);
        var newData = data.setScale(2, RoundingMode.HALF_UP);
        System.out.println(newData);
    }

    @Test
    @DisplayName("BigDecimal equals method test")
    public void testEquals() {
        BigDecimal num = new BigDecimal("3.02");
        System.out.println("(BigDecimal.ZERO.equals(num), result : " + (BigDecimal.ZERO.equals(num)));
        System.out.println("BigDecimal.ZERO.equals(null), result : " + (BigDecimal.ZERO.equals(null)));
        System.out.println("BigDecimal.ZERO.equals(new BigDecimal(\"0.00\")) ,result : " + (BigDecimal.ZERO.equals(new BigDecimal("0.00"))));

        System.out.println("BigDecimal.ZERO.compareTo(num) == 0 ,result : " + (BigDecimal.ZERO.compareTo(num) == 0));
        System.out.println("BigDecimal.ZERO.compareTo(new BigDecimal(\"0.00\")) == 0 ,result : " + (BigDecimal.ZERO.compareTo(new BigDecimal("0.00")) == 0));

        System.out.println("结论： BigDecimal 不能用equals 判定，数字判定最好使用compareTo 方法");
    }

}
