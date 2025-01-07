package com.example.base.utils.io.support.words;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

/**
 * Created  on 2024-7-12 16:16:13
 *
 * @author zl
 */
class WordParseUtilTest {

    @Test
    @DisplayName("行数据解析单词测试")
    void parse() {
        String line = "6 arrest [ə'rest] v.逮捕";
        LineDataParseDTO parse = WordParseUtil.parse(line);
        System.out.println("parse = " + parse);
    }

    @Test
    void testParse() throws IOException {
        String filePath = "D:\\alist-workspace\\BaiduSyncdisk\\word-list\\Lesson 1-34.txt";
        String descDirPath = "D:\\alist-workspace";
        WordParseUtil.printEnglish(filePath, descDirPath);
    }
}
