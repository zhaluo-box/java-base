package com.example.base.utils.io;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Created  on 2023/7/20 14:14:38
 *
 * @author zl
 */
class CharacterRecognitionTest {

    @Test
    @DisplayName("测试是否拥有字符")
    void testHasCharacter() {
    }

    @Test
    @DisplayName("测试是否正则匹配")
    void testPattern() {
    }

    @Test
    @DisplayName("测试提取数据")
    void testExtractData() {

        var imageStr = "![img](59 探秘黑科技：RocketMQ 是如何基于Netty扩展出高性能网络通信架构的？.assets/DM_20230615162509_002.PNG) ";

        var data = MarkdownUtil.extractData(imageStr, "](", ")");

        System.out.println("data = " + data);

    }
}
