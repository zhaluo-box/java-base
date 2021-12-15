package com.example.test.file;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * 临时文件测试
 */
public class TemplateFileTest {

    @Test
    public void testTmpFile() {
        try {
            Path tmpFilePath = Files.createTempFile("tmp-file-prefix", ".txt");
            String content = "测试临时文件";
            var bytes = content.getBytes(StandardCharsets.UTF_8);
            Files.write(tmpFilePath, bytes);
            System.out.println(tmpFilePath.toFile().exists());
            System.out.println(tmpFilePath.toString());

            System.out.println(System.getProperty("java.io.tmpdir"));
            File tempFile = File.createTempFile("code-template", ".csv");
            System.out.println("  临时文件的绝对路径 : " + tempFile.getAbsolutePath());

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
