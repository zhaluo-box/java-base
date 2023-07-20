package com.example.base.utils.io;

import cn.hutool.core.net.URLEncodeUtil;
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
    }

    @Test
    void handle() {
        MarkdownUtil.handle("D:\\tmp-dir\\docs\\", "D:\\tmp-dir\\md-back\\docs\\");
    }
}
