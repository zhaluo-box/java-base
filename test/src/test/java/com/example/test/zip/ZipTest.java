package com.example.test.zip;

import lombok.Cleanup;
import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class ZipTest {

    @Test
    public void unZipTest() throws IOException {
        var filePath = "C:\\testDir\\app.zip";
        var descPath = "C:\\testDir\\zip-tmp";
        unZip(filePath, descPath);
    }

    private String unZip(String filePath, String descPath) throws IOException {
        File srcFile = new File(filePath);
        if (!srcFile.exists()) {
            System.out.println("文件不存在");
        }
        descPath = descPath + File.separator + this.getMidPath(filePath);
        //创建压缩文件对象
        ZipFile zipFile = new ZipFile(srcFile);
        //开始解压
        Enumeration<?> entries = zipFile.entries();
        while (entries.hasMoreElements()) {
            ZipEntry entry = (ZipEntry) entries.nextElement();
            // 如果是文件夹，就创建个文件夹
            if (entry.isDirectory()) {
                srcFile.mkdirs();
            } else {
                // 如果是文件，就先创建一个文件，然后用io流把内容copy过去
                File targetFile = new File(descPath + File.separator + entry.getName());
                // 保证这个文件的父文件夹必须要存在
                if (!targetFile.getParentFile().exists()) {
                    targetFile.getParentFile().mkdirs();
                }
                targetFile.createNewFile();
                @Cleanup InputStream is = zipFile.getInputStream(entry);
                @Cleanup FileOutputStream fos = new FileOutputStream(targetFile);
                int len;
                byte[] buf = new byte[1024];
                while ((len = is.read(buf)) != -1) {
                    fos.write(buf, 0, len);
                }
            }
        }
        return descPath;
    }

    private String getMidPath(String filePath) {
        return filePath.substring(filePath.lastIndexOf(File.separator), filePath.lastIndexOf("."));
    }
}
