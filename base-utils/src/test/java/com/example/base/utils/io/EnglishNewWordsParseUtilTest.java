package com.example.base.utils.io;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.io.FileUtil;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Date;

/**
 * Created  on 2024-3-6 17:17:28
 *
 * @author zl
 */
class EnglishNewWordsParseUtilTest {

    @Test
    void parse() throws IOException {
        var source = "D:\\alist-workspace\\word-list\\Lesson 35-36 .txt";
        var name = FileUtil.getName(source);
        name = name.replace(".txt", "");
        var suffix = DateUtil.format(new Date(), "yyyy-MM-dd");
        var target = "D:\\alist-workspace\\word-list\\" + name + "-" + suffix + ".txt";
        EnglishNewWordsParseUtil.parse(source, target);
    }
}
