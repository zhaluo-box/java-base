package com.example.base.utils.io;

import cn.hutool.core.io.FileUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

/**
 * Created  on 2024-3-6 17:17:28
 *
 * @author zl
 */
class EnglishNewWordsParseUtilTest {

    @Test
    void parse() throws IOException {
        var source = "D:\\alist-workspace\\word-list\\Lesson 53-54.txt";
        var name = FileUtil.getName(source);
        //        name = name.replace(".txt", "");
        //        var suffix = DateUtil.format(new Date(), "yyyy-MM-dd");
        var target = "D:\\alist-workspace\\word-list\\parse\\" + name;
        EnglishNewWordsParseUtil.parse(source, target);
    }

    @Test
    @DisplayName("合并单词，并输出到一个all文件")
    void mergeMultiFileWords() throws IOException {
        var dirPath = "D:\\alist-workspace\\word-list";

        var dir = new File(dirPath);
        if (!dir.isDirectory()) {
            return;
        }

        var list = new ArrayList<String>();
        Arrays.stream(Objects.requireNonNull(dir.listFiles()))
                .sorted(Comparator.comparing(File::getName))
                .filter(file -> file.length() > 0 && !file.isDirectory())
                .forEach(file -> {
                    var source = file.getAbsolutePath();
                    var name = FileUtil.getName(source);
                    System.out.println(source);
                    var target = "D:\\alist-workspace\\word-list\\parse\\" + name;
                    try {
                        list.addAll(EnglishNewWordsParseUtil.mergeMultiFile(source, target));
                    } catch (Exception e) {
                        e.printStackTrace();
                        System.out.println(e.getMessage());
                    }
                });

        FileUtil.writeLines(list, "D:\\alist-workspace\\word-list\\parse\\all.txt", "UTF-8");
    }

    @Test
    @DisplayName("批量解析")
    void batchParse() throws IOException {
        var dirPath = "D:\\alist-workspace\\word-list";

        var dir = new File(dirPath);
        if (!dir.isDirectory()) {
            return;
        }
        Arrays.stream(Objects.requireNonNull(dir.listFiles()))
                .sorted(Comparator.comparing(File::getName))
                .filter(file -> file.length() > 0 && !file.isDirectory())
                .forEach(file -> {
                    var source = file.getAbsolutePath();
                    var name = FileUtil.getName(source);
                    System.out.println(source);
                    var target = "D:\\alist-workspace\\word-list\\parse\\" + name;
                    try {
                        EnglishNewWordsParseUtil.parse(source, target);
                    } catch (Exception e) {
                        e.printStackTrace();
                        System.out.println(e.getMessage());
                    }
                });
    }

    @Test
    @DisplayName("创建文件名")
    void createFiles() {
        for (int i = 57; i <= 144; i = i + 2) {
            String fileName = "D:\\alist-workspace\\word-list\\Lesson " + i + "-" + (i + 1) + ".txt";
            createFile(fileName);
        }
    }

    void createFile(String fileName) {
        File file = new File(fileName);
        try {
            if (file.createNewFile()) {
                System.out.println("文件创建成功： " + file.getName());
            } else {
                System.out.println("文件已存在： " + file.getName());
            }
        } catch (IOException e) {
            System.out.println("创建文件失败： " + file.getName());
            e.printStackTrace();
        }
    }

    @Test
    void testDeviceZero() {
        var x = 0 / 12;
        System.out.println(x);
        var y = 14 % 12;
        System.out.println("y = " + y);
    }
}
