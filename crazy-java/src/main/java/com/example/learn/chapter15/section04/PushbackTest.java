package com.zhaluobox.crazyjava.chapter15.section04;

import java.io.*;

public class PushbackTest {
    public static void main(String[] args) {
        try (
                // 创建一个PushbackReader对象，指定推回缓冲区的长度为1024
                PushbackReader pr = new PushbackReader(new FileReader("C:\\githubspace\\crazyjava\\README.md"), 1024)
        ) {
            //定义一个缓存区
            char[] buf = new char[64];
            // 用以保存上次读取的字符串内容
            String lastContent = "";
            int hasRead = 0;
            // 循环读取文件内容
            while ((hasRead = pr.read(buf)) > 0) {
                // 将读取的内容转换成字符串
                String content = new String(buf, 0, hasRead);
                int targetIndex = 0;
                // 将上次读取的字符串和本次读取的字符串拼起来，
                // 查看是否包含目标字符串, 如果包含目标字符串
                if ((targetIndex = (lastContent + content).indexOf("字节流和字符流")) > 0) {
                    // 将本次内容和上次内容一起推回缓冲区
                    pr.unread((lastContent + content).toCharArray());
                    // 重新定义一个长度为targetIndex的char数组
                    if (targetIndex > 32) {
                        buf = new char[targetIndex];
                    }
                    // 再次读取指定长度的内容（就是目标字符串之前的内容）
                    pr.read(buf, 0, targetIndex);
                    // 打印读取的内容
                    System.out.print(new String(buf, 0, targetIndex));
                    System.exit(0);
                } else {
                    // 打印上次读取的内容
                    System.out.print(lastContent);
                    // 将本次内容设为上次读取的内容
                    lastContent = content;
                }
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
