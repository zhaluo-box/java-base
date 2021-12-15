package com.example.test.network.url;

import lombok.SneakyThrows;
import org.junit.Test;

import java.net.URL;
import java.net.URLClassLoader;

/**
 * URL 测试!
 */
public class URLTest {

    @Test
    @SneakyThrows
    public void urlBaseLearn() {
        var url = new URL("Https:www.baidu.com");
        System.out.println("URL 协议 : " + url.getProtocol());
        System.out.println("URL 路径 : " + url.getPath());
        System.out.println("URL host : " + url.getHost());
        var urlClassLoader = new URLClassLoader(new URL[] { new URL("Https:www.baidu.com") }, this.getClass().getClassLoader());
        System.out.println(urlClassLoader);
        var urlClassLoader2 = new URLClassLoader(new URL[] { new URL("Https:www.baidu.com") }, this.getClass().getClassLoader());
        System.out.println(urlClassLoader2);

        System.out.println(new URL("jar:file:9989!/").getPath());
        System.out.println(new URL("file:" + "jarFile.getName()" + "!/").getPath());

    }

}
