package com.example.base.test.util;

import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created  on 2022/11/2 16:16:43
 *
 * @author zl
 */
public class DateTest {

    @Test
    @DisplayName("测试两个时间的差")
    public void test() {
        String dateStr1 = "2017-03-01 22:33:23";
        Date date1 = DateUtil.parse(dateStr1);

        String dateStr2 = "2017-04-01 23:33:23";
        Date date2 = DateUtil.parse(dateStr2);

        //相差一个月，31天
        System.out.println("DateUtil.between(date1, date2, DateUnit.DAY, false) = " + DateUtil.between(date1, date2, DateUnit.DAY, false));
        System.out.println("DateUtil.between(date2, date1, DateUnit.DAY, false) = " + DateUtil.between(date2, date1, DateUnit.DAY, false));

    }

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
