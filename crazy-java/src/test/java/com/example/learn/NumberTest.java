package com.example.learn;

import org.junit.Test;

import java.math.BigDecimal;

public class NumberTest {

    @Test
    public void test1() {
        for (int i = 0; i < 100; i++) {
            if (i % 5 == 0) {
                System.out.println(i);
            }
//            System.out.println(i / 5);
        }
    }

    /**
     * 测试结论 : bigdecimal 不能为null ,很容易报空指针异常
     */
    @Test
    public void test2(){
        BigDecimal b = BigDecimal.ZERO;
        BigDecimal c = null;
        b = b.add(c);
        System.out.println(b);
    }
}
