package com.example.base.utils.io.support.words;

import cn.hutool.core.util.StrUtil;

/**
 * Created  on 2024-7-12 15:15:40
 *
 * @author zl
 */
public interface LineParse {

    /**
     * 是否是空行
     *
     * @param line 行数据
     * @return true:是空行，false:不是空行
     */
    default boolean empty(String line) {
        return StrUtil.isBlank(line);
    }

    default String preparedLine(String line) {

        return line;
    }

    LineDataParseDTO parse(String line);

    /**
     * @param line 行数据
     * @return 获取音标
     */
    default String phonetic(String line) {
        if (line.contains("[")) {
            return line.substring(line.indexOf("[") + 1, line.indexOf("]")).trim();
        }
        return null;
    }

    /**
     * @param line 行数据
     * @return 获取音标
     */
    default String chinese(String line) {
        if (line.contains("[")) {
            var chinese = line.substring(line.indexOf("]") + 1);
            return chinese.trim();
        }
        return null;
    }

    /**
     * [ 之前的数据， 是否含有serialNum, 截取最后一个数字后的数据
     *
     * @param line 行数据
     * @return 获取音标
     */
    default String english(String line) {
        if (line.contains("[")) {
            var chinese = line.substring(0, line.indexOf("["));
            return chinese.replace(serialNum(line), "").trim();
        }
        return null;
    }

    /**
     * @param line 行数据
     * @return 获取音标
     */
    default String serialNum(String line) {
        // 截取第一个英文字母之前的字符， 如果含有数字且为纯数字与空格，保留纯数字
        StringBuilder prefix = new StringBuilder();
        boolean foundLetter = false;

        // Build the prefix until the first letter is encountered
        for (char c : line.toCharArray()) {
            if (Character.isLetter(c)) {
                foundLetter = true;
                break;
            }
            prefix.append(c);
        }

        if (foundLetter && prefix.toString().matches("^[\\d\\s]*$")) {
            // Remove all spaces to return only digits
            return prefix.toString().replaceAll("\\s+", "");
        }

        return prefix.toString();
    }
}
