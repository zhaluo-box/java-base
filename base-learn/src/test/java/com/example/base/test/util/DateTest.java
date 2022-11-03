package com.example.base.test.util;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created  on 2022/11/2 16:16:43
 *
 * @author zl
 */
public class DateTest {

    @Test
    @DisplayName("时差测试  单位秒")
    public void timeDiffTest() throws InterruptedException {
        var startTime = new Date();
        TimeUnit.SECONDS.sleep(5);
        var endTime = new Date();
        System.out.println(computeDiffTime(startTime, endTime));
    }

    private long computeDiffTime(Date start, Date end) {
        System.out.println(start.getTime());
        System.out.println(end.getTime());
        return (end.getTime() - start.getTime()) / 1000;
    }
}
