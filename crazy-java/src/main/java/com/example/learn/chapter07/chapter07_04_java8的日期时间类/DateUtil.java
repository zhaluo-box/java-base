package com.zhaluobox.crazyjava.chapter07.chapter07_04_java8的日期时间类;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;
import java.util.function.Consumer;

/**
 * 日期工具类
 *
 * @author 扎罗
 * @version 1.0.0
 * @Date 2020-8-11 9:44
 */
public class DateUtil {

    public static void main(String[] args) {
        dateLoop( "20200619", "20200817", (cal) -> {
            final Date time = cal.getTime();
           System.out.println( dateFormat( time, "yyyyMMdd" ) );
        } );
    }

    /**
     * 日期循环.
     *
     * @param dateStart 起始日期 格式yyyyMMdd
     * @param dateEnd   截止日期 格式yyyyMMdd
     */
    public static void dateLoop(String dateStart, String dateEnd,
                                Consumer<Calendar> consumer) {
        // 日期字符串拆分
        Objects.requireNonNull( dateStart, "起始日期不能为null" );
        Objects.requireNonNull( dateEnd, "结束日期不能为null" );
        final String year = dateStart.substring( 0, 4 );
        final String month = dateStart.substring( 4, 6 );
        final String day = dateStart.substring( 6, 8 );
        final String year2 = dateEnd.substring( 0, 4 );
        final String month2 = dateEnd.substring( 4, 6 );
        final String day2 = dateEnd.substring( 6, 8 );
        // 转换为Calendar类
        final Calendar cal = Calendar.getInstance();
        cal.set( Integer.parseInt( year ), Integer.parseInt( month )-1,
                Integer.parseInt( day ) );
        //System.out.println(year+month+day);
        final Date time = cal.getTime();
        //System.out.println(cal.get( Calendar.MONTH ));
        //System.out.println( dateFormat( time, "yyyyMMdd" ) );
        final Calendar cal2 = Calendar.getInstance();
        cal2.set( Integer.parseInt( year2 ), Integer.parseInt( month2 )-1,
                Integer.parseInt( day2 ) );

        // 循环
        while (cal.compareTo( cal2 ) < 1) {
            consumer.accept( cal );
            cal.add( Calendar.DAY_OF_MONTH, 1 );
        }
    }


    /**
     * 日期转字符串.
     *
     * @param date    日期
     * @param pattern 模式
     * @return 日期字符串
     */
    public static String dateFormat(Date date, String pattern) {
        final DateFormat dateFormat = new SimpleDateFormat( pattern );
        return dateFormat.format( date );
    }

    /**
     * 日期或者月份小于10 处理
     *
     * @param dayOrMonth 日或者月份
     * @return String
     */
    private String lessThenTenHandler(String dayOrMonth) {
        Objects.requireNonNull( dayOrMonth, "日期不能为空" );
        final int i = Integer.parseInt( dayOrMonth );
        if (i < 10)
            return "0" + i;
        return String.valueOf( i );
    }
}
