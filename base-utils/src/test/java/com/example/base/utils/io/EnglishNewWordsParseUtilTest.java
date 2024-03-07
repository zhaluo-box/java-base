package com.example.base.utils.io;

import cn.hutool.core.date.DateUtil;
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
        var source = "D:\\tmp-dir\\word-list\\words.txt";
        var suffix = DateUtil.format(new Date(), "yyyy-MM-dd");
        var target = "D:\\tmp-dir\\word-list\\" + suffix + ".txt";
        EnglishNewWordsParseUtil.parse(source, target);
    }
}
