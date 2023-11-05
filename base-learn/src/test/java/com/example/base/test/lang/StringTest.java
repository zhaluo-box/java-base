package com.example.base.test.lang;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.regex.Pattern;

/**
 * Created  on 2022/9/29 16:16:28
 *
 * @author zl
 */
public class StringTest {

    @Test
    @DisplayName("String format 测试 format == 测试事件1 【 %s 】 【 %s 】")
    public void formatTest() {

        var objects = new ArrayList<>();
        objects.add("name");
        objects.add("11");

        var s = String.format("测试事件1 【 %s 】 【 %s 】", objects.toArray());
        System.out.println(s);
    }

    @Test
    @DisplayName("String 日期 format 测试")
    public void dateFormatTest() {

        var objects = new ArrayList<>();
        objects.add("name");
        objects.add(new Date());

        System.out.println(String.format("测试事件1 【 %s 】 【 %tc 】", objects.toArray()));
        System.out.println(String.format("测试事件2 【 %s 】 【 %tF 】", objects.toArray()));
        System.out.println(String.format("测试事件3 【 %s 】 【 %tD 】", objects.toArray()));
        System.out.println(String.format("测试事件4 【 %s 】 【 %tr 】", objects.toArray()));
        System.out.println(String.format("测试事件5 【 %s 】 【 %tT 】", objects.toArray()));
        System.out.println(String.format("测试事件6 【 %s 】 【 %tR 】", objects.toArray()));
        System.out.println(String.format("测试事件6 【 %s 】 【 %tFT 】", objects.toArray()));
    }

    /**
     * 正则测试
     * {@link <a href="https://blog.csdn.net/weixin_42333548/article/details/121958512?ops_request_misc=%257B%2522request%255Fid%2522%253A%2522166425952216782412579066%2522%252C%2522scm%2522%253A%252220140713.130102334..%2522%257D&request_id=166425952216782412579066&biz_id=0&utm_medium=distribute.pc_chrome_plugin_search_result.none-task-blog-2~all~top_click~default-1-121958512-null-null.nonecase&utm_term=%E5%AF%86%E7%A0%81%E6%AD%A3%E5%88%99%E8%A1%A8%E8%BE%BE%E5%BC%8F%E5%A4%A7%E5%85%A8&spm=1018.2226.3001.4187">...</a>}
     */

    @Test
    @DisplayName("字符串 正则校验")
    public void patternTest() {
        var pwd = "Aa1234567890@";
        var pattern = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[~!@#$%^&*()_+;'/.,]).{10,}";
        System.out.println(Pattern.matches(pattern, pwd));
    }

    @Test
    public void pwdTest() {
        //        var pwd = "Aa1234567890@";
        var pwd = "Aa1234567890XX##";
        var pattern = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{10,30}$";

        var xx = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{10,}";

        var pa = "/^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[`~!！@#$^&*()=|{}':;,.<>《》+_…）—【】‘；：”“。，、？]).{10,30}$";
        System.out.println(Pattern.matches(pa, pwd));
        System.out.println(pattern.matches(pwd));
    }

    @Test
    @DisplayName("字符串parse 测试")
    public void testParse() {

        var originalParams = new HashMap<String, Object>();
        originalParams.put("kunnrHigh", "900000001");
        originalParams.put("kunnrLow", "000000001");
        originalParams.put("sharedSize", 10000);

        String kunnrHigh = String.valueOf(originalParams.get("kunnrHigh"));
        String kunnrLow = String.valueOf(originalParams.get("kunnrLow"));
        String sharedSize = String.valueOf(originalParams.get("sharedSize"));

        long high = Long.parseLong(kunnrHigh);
        long low = Long.parseLong(kunnrLow);
        long size = Long.parseLong(sharedSize);

        System.out.println("high = " + high);
        System.out.println("low = " + low);
        System.out.println("size = " + size);
    }

    @Test
    @DisplayName("字符串替换测试")
    public void replaceTest() {
        String packageName = "com.example.base.test.lang.StringTest";
        System.out.println("packageName.replace(\".\",\"/\") = " + packageName.replace(".", "/"));
        System.out.println("packageName.replaceAll(\"\\\\.\", \"/\") = " + packageName.replaceAll("\\.", "/"));
    }

    @Test
    @DisplayName("文件名排序测试")
    public void strSortTest() {

        String str[] = new String[] { "01-课程介绍.mp4", "02-内容综述.mp4", "10你好", "101数据库", "21你好", "23十六岁" };

        Arrays.stream(str).sorted().forEach(System.out::println);
    }

}
