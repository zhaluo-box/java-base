package com.example.base.test.lang;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.ArrayList;
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

    /**
     * 正则测试
     * {@link <a href="https://blog.csdn.net/weixin_42333548/article/details/121958512?ops_request_misc=%257B%2522request%255Fid%2522%253A%2522166425952216782412579066%2522%252C%2522scm%2522%253A%252220140713.130102334..%2522%257D&request_id=166425952216782412579066&biz_id=0&utm_medium=distribute.pc_chrome_plugin_search_result.none-task-blog-2~all~top_click~default-1-121958512-null-null.nonecase&utm_term=%E5%AF%86%E7%A0%81%E6%AD%A3%E5%88%99%E8%A1%A8%E8%BE%BE%E5%BC%8F%E5%A4%A7%E5%85%A8&spm=1018.2226.3001.4187">...</a>}
     */

    @Test
    @DisplayName("字符串 正则校验")
    public void patternTest() {
        var pattern = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[$@$!%*?&])[A-Za-z\\d$@$!%*?&]{10,}";
        System.out.println(Pattern.matches(pattern, "Admin123456!"));
    }
}
