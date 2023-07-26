package com.example.base.test.util;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

/**
 * java 提供的日历测试
 * Created  on 2023/7/26 11:11:23
 *
 * @author zl
 */
public class CalendarTest {

    private static final String TIME_FORMATTER = "yyyy-MM-dd HH:mm:ss";

    @Test
    @DisplayName("测试添加天")
    public void addDayTest() {
        var calendar = getCalendar(null);
        System.out.println("calendar.getTime() = " + DateUtil.format(calendar.getTime(), TIME_FORMATTER));

        calendar.add(Calendar.DAY_OF_MONTH, 7);
        System.out.println("calendar.getTime() = " + DateUtil.format(calendar.getTime(), TIME_FORMATTER));
    }

    @Test
    @DisplayName("测试calendar 比较")
    public void afterTest() throws ParseException {

        var calendar1 = getCalendar(getDate("2023-07-26 11:35:01", TIME_FORMATTER));
        var calendar3 = getCalendar(getDate("2023-07-26 11:35:00", TIME_FORMATTER));
        var calendar2 = getCalendar(getDate("2023-08-02 11:35:00", TIME_FORMATTER));

        System.out.println("calendar1.after(calendar2) = " + calendar1.after(calendar2));
        System.out.println("calendar1.after(calendar3) = " + calendar1.after(calendar3));

    }

    private Calendar getCalendar(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(Objects.isNull(date) ? new Date() : date);
        return calendar;
    }

    private Date getDate(String time, String formatter) throws ParseException {
        formatter = StrUtil.isBlank(formatter) ? TIME_FORMATTER : formatter;
        DateFormat format = new SimpleDateFormat(formatter);
        return format.parse(time);
    }

    //    private void determineCalendar(Integer timeOffset, Integer timeunit, Calendar calendar) {
    //        if (TimeUnitEnum.DAY.getValue().equals(timeunit)) {
    //            calendar.add(Calendar.DATE, timeOffset);
    //        } else if (TimeUnitEnum.WEEK.getValue().equals(timeunit)) {
    //            calendar.add(Calendar.DATE, 7 * timeOffset);
    //        } else if (TimeUnitEnum.MONTH.getValue().equals(timeunit)) {
    //            calendar.add(Calendar.MONTH, timeOffset);
    //        } else if (TimeUnitEnum.HALF_YEAR.getValue().equals(timeunit)) {
    //            calendar.add(Calendar.MONTH, timeOffset * 6);
    //        } else if (TimeUnitEnum.YEAR.getValue().equals(timeunit)) {
    //            calendar.add(Calendar.YEAR, timeOffset);
    //        }
    //    }
}
