package com.example.base.utils.io;

import cn.hutool.core.net.URLEncodeUtil;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

/**
 * 字符识别
 * Created  on 2023/7/19 16:16:34
 *
 * @author zl
 */
public abstract class CharacterRecognition {

    /**
     * 行内是否含有特殊字符
     * ![
     * ](
     *
     * @param line      行数据
     * @param character 特殊字符
     * @return 是否含有
     */
    protected static boolean hasCharacter(String line, String character) {
        return line.contains(character);
    }

    /**
     * 正则判定当前行数据是否符合
     *
     * @param line  行数据
     * @param regex 正则表达式
     * @return 是否符合
     */
    protected static boolean pattern(String line, String regex) {
        return line.matches(regex);
    }

    /**
     * 提取 字符
     *
     * @param source 原字符串
     * @param from   开始字符
     * @param end    结束字符
     * @return 开始与结束字符之间的内容，不包含，开始与结束字符
     */
    protected static String extractData(String source, String from, String end) {
        var fromIndex = source.indexOf(from);
        var endIndex = source.indexOf(end, fromIndex);
        return source.substring(fromIndex + from.length(), endIndex);
    }

    /**
     * 对链接进行URL 加密
     *
     * @param link 连接
     * @return 加密link
     */
    protected static String encodeLink(String link) {
        return URLEncodeUtil.encode(link, StandardCharsets.UTF_8);
    }

    /**
     * 对链接进行URL 解密
     *
     * @param link 链接
     * @return 解密后的链接
     */
    protected static String decodeLink(String link) {
        link = URLDecoder.decode(link, StandardCharsets.UTF_8);
        link = URLDecoder.decode(link, StandardCharsets.UTF_8);
        return URLDecoder.decode(link, StandardCharsets.UTF_8);
    }

    /**
     * 替换特殊字符
     *
     * @param content   字符内容
     * @param specChars 特殊字符【】
     * @return 替换后的数据
     */
    protected static String hasSpecCharAndReplace(String content, String... specChars) {

        String temp = content;

        for (String specChar : specChars) {
            temp = temp.replace(specChar, "");
        }

        return temp;
    }

}
