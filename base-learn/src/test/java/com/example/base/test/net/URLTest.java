package com.example.base.test.net;

import cn.hutool.core.io.IoUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;

/**
 * Created  on 2023/9/7 15:15:47
 *
 * @author zl
 */
public class URLTest {

    @Test
    @DisplayName("Java文件协议解析")
    public void testFileProtocol() {

        // 错误URL String urlPath = "file://D:/workspace\\personal\\java-base\\base-learn\\src\\test\\java\\com\\example\\base\\test\\net\\URLTest.java";
        // 在URL 中应该 在Java中，文件路径应该使用正斜杠（/）而不是反斜杠（\）。
        String urlPath = "file:///D:/workspace/personal/java-base/base-learn/src/test/java/com/example/base/test/net/URLTest.java";

        try {
            var url = new URL(urlPath);
            var inputStream = url.openStream();
            var bufferedReader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
            System.out.println(IoUtil.read(bufferedReader));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
