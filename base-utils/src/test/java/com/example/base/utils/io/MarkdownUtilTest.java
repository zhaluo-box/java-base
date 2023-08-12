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
        MarkdownUtil.TyporaToObsidian("D:\\tmp-dir\\待整理\\md_note", "D:\\tmp-dir\\ob-back\\docs\\", "images");
    }

    @Test
    void encodeTest() {
        var str = "images/111%20我们的系统与RocketMQ%20Broker之间是如何进行网络通信的.4.png";

        var link = MarkdownUtil.decodeLink(str);
        System.out.println("link = " + link);

        var en = MarkdownUtil.encodeLink(link);
        System.out.println("en = " + en);
    }

    @Test
    @DisplayName("URL 解码测试")
    void decodeLinkTest() {
        var link = "72 Broker消息零丢失方案：同步刷盘 + Raft协议主从同步.assets/DM_20230619101738_001.PNG";
        System.out.println("MarkdownUtil.decodeLink(link) = " + MarkdownUtil.decodeLink(link));

        System.out.println("URLDecoder.decode(link,StandardCharsets.UTF_8) = " + URLDecoder.decode(link, StandardCharsets.UTF_8));

    }

    @Test
    @DisplayName("提取数据测试")
    public void extractDataTest() {
        var str = "倒排索引源于实际应用中需要根据属性的值来查找记录。这种索引表中的每一项都包括一个属性值和具有该属性值的各记录的地址"
                  + "。**由于不是由记录来确定属性值，而是由属性值来确定记录的位置，因而称为倒排索引(inverted index)**。"
                  + "带有倒排索引的文件我们称为倒排[索引文件](https://baike.baidu.com/item/索引文件)，"
                  + "简称[倒排文件](https://baike.baidu.com/item/倒排文件/4137688)(inverted file)。";

        var x = "[123](192)";

        var linkStr = MarkdownUtil.extractData(str, "](", ")");
        System.out.println("linkStr = " + linkStr);

        var linkStrx = MarkdownUtil.extractData(x, "](", ")");
        System.out.println("linkStrx = " + linkStrx);

    }
}
