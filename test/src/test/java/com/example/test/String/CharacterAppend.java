package com.example.test.String;

import org.junit.Test;

import java.util.Arrays;

public class CharacterAppend {

    @Test
    public void appendDatabaseField() {
        appendAndToString(92, 10);
    }

    @Test
    public void test() {
        System.out.println("0".repeat(1) + "x");
        System.out.println(Arrays.toString(generateFields(7)));
    }

    private void appendAndToString(int i, int len) {
        int offset = i % len;
        int x = i / len;
        if (offset > 0) {
            x += 1;
        }
        var tmp = String.valueOf(i);
        var length = tmp.length();
        var standardLength = Math.max(length, 2);
        for (int k = 1; k <= x; k++) {
            var builder = new StringBuilder();
            var tmpl = 10;
            if (offset > 0 && k == x) {
                tmpl = offset;
            }
            for (int j = 1; j <= tmpl; j++) {
                var index = (k - 1) * len + j;
                var aa = strFormat(index, standardLength);
                builder.append("\"").append("S").append(aa).append("\"");
                if (k == x && j == tmpl) {
                    continue;
                }
                builder.append(",");
            }
            System.out.println(builder);
        }
    }






    /**
     * 字符串格式化.
     *
     * @param i   当前索引
     * @param len 长度
     */
    private String strFormat(int i, int len) {
        var tmp = String.valueOf(i);
        var standardLength = Math.max(len, 2);
        // 数字转字符串
        // 如果字符串长度不足, 则前面补零
        var offset = standardLength - tmp.length();
        if (offset <= 0) {
            return i + "";
        }
        return "0".repeat(offset) + i;
    }

    /**
     * @param fieldSize 字段个数
     */
    private String[] generateFields(int fieldSize) {
        var fields = new String[fieldSize];
        for (int i = 0; i < fieldSize; i++) {
            var value = strFormat(i + 1, String.valueOf(fieldSize).length());
            fields[i] = "S" + value;
        }
        return fields;
    }

}
