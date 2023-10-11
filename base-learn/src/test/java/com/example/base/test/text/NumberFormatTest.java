package com.example.base.test.text;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * Created  on 2023/10/11 14:14:37
 *
 * @author zl
 */
public class NumberFormatTest {


    @Test
    @DisplayName("数字format测试")
    public void formatterTest() {

        var numberInstance = NumberFormat.getNumberInstance();

        var result = numberInstance.format(20.00);
        System.out.println("result = " + result);

        DecimalFormat df = new DecimalFormat("#.00");
        df.applyPattern("#.##");
        System.out.println("#.## df.format(0) = " + df.format(0));
        System.out.println("#.## df.format(12.00) = " + df.format(12.00));

        df.applyPattern("0.00");
        System.out.println("0.00  df.format(12.00f) = " + df.format(12.00f));

        df.applyPattern("0.##");
        System.out.println("0.##  df.format(12.00f) = " + df.format(12.00f));

        System.out.println("new Double(df.format(12)) = " + new Double(df.format(12)));

    }

}


