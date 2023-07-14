package com.example.base.test.io;

import com.example.base.learn.io.utils.FileUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;

/**
 * Created  on 2022/9/16 14:14:13
 *
 * @author zl
 */
public class FileTest {

    @Test
    @DisplayName("扫描文件目录并制作markdown")
    public void printDirToMDTest() {
        var rootFilename = "D:\\learn-video\\140.小马哥讲Spring核心编程思想";
        FileUtil.printFileDirectoryToMD(rootFilename, "C:\\Users\\wmz\\Documents", "小马哥Spring目录.md");
    }

    @Test
    @DisplayName("扫描文件目录并制作markdown")
    public void printDirToMDTest2() {
        var rootFilename = "D:\\learn-video";
        FileUtil.printFileDirectoryToMD(rootFilename, "C:\\Users\\wmz\\Documents", "learn-video.md");
    }

    @Test
    @DisplayName("文件名测试")
    public void fileNameTest() {

        var file = new File("D:\\workspace\\personal\\java-base\\base-learn\\src\\test\\java\\com\\example\\base\\test\\io\\FileTest.java");
        System.out.println("file.getName() = " + file.getName());
        System.out.println("file.getAbsolutePath() = " + file.getAbsolutePath());

    }
}
