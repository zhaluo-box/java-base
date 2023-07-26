package com.example.base.utils.io;

import cn.hutool.core.net.URLDecoder;
import cn.hutool.core.net.URLEncodeUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

/**
 * Created  on 2023/7/20 15:15:07
 *
 * @author zl
 */
class MarkdownUtilTest {

    @Test
    void handleSingle() throws IOException {
        MarkdownUtil.handleSingle("D:\\tmp-dir\\docs\\MQ\\rocketMQ\\118 Consumer是如何从Broker上拉取一批消息过来处理的？.md",
                                  "D:\\tmp-dir\\docs\\MQ\\rocketMQ\\118 Consumer是如何从Broker上拉取一批消息过来处理的(1)？.md");
    }

    /**
     * 由于Java URLEncoder 空格会转义为 + ， 所以采用 hu-tool URLEncodeUtil RFC3986协议，对空格特殊处理
     */
    @Test
    void encodeUrl() {
        var encode = URLEncoder.encode("118 Consumer是如何从Broker上拉取一批消息过来处理的？.assets/40091600_1586340313.png", StandardCharsets.UTF_8);
        System.out.println("encode = " + encode);
        var x = URLEncodeUtil.encode("118 Consumer是如何从Broker上拉取一批消息过来处理的？.assets/40091600_1586340313.png", StandardCharsets.UTF_8);

        System.out.println("x = " + x);

        var decode = URLDecoder.decode(".%5Cframeworkspring%5Cmercy-spring.md", StandardCharsets.UTF_8);
        System.out.println("decode = " + decode);
    }

    @Test
    void handle() {
        MarkdownUtil.handle("D:\\tmp-dir\\docs\\", "D:\\tmp-dir\\md-back\\docs\\");
    }

    @Test
    @DisplayName("生成MD大纲测试")
    void generateOutlineMD() {
        MarkdownUtil.generateOutlineMD("D:\\tmp-dir\\md-back\\docs\\", "D:\\tmp-dir\\md-back\\mq-outline.md");
    }

    @Test
    @DisplayName("生成MD大纲测试")
    void generateOutlineMDNoEncodeLink() {
        MarkdownUtil.generateOutlineMD("D:\\tmp-dir\\docs\\", "D:\\tmp-dir\\doc-outline.md", false, false);
    }

    @Test
    @DisplayName("typora md 转 ob md")
    void typoraToObsidianTest() {
        MarkdownUtil.TyporaToObsidian("D:\\tmp-dir\\docs\\", "D:\\tmp-dir\\ob-back\\docs\\", "images");
    }

    @Test
    @DisplayName("URL 解码测试")
    void decodeLinkTest() {
        var link = "03%20BeanFactoryPostProcessor%20and%20Mybatis-spring.assets/image-20230719144931003.png";
        System.out.println("MarkdownUtil.decodeLink(link) = " + MarkdownUtil.decodeLink(link));
    }
}
