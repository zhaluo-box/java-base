package com.example.base.utils.io;

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

        // TODO  2023/7/19 待实现
        return null;
    }

}
