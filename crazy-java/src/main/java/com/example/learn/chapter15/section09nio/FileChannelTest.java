package com.zhaluobox.crazyjava.chapter15.section09nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

/**
 * 1. 创建文件
 * 2. 通过流获取管道
 * 3. 转换成buffer
 */
public class FileChannelTest {
    public static void main(String[] args) {

        final File f = new File("a.txt");
        //try with resource 的写法
        try (
                // 1 创建FileInputStream，以该文件输入流创建FileChannel
                FileChannel inChannel = new FileInputStream(f).getChannel(); //FileInputStream获取的FileChannel只能读，FileOutputStream只能写
                // 2  以文件输出流创建FileBuffer，用以控制输出
                FileChannel outChannel = new FileOutputStream("b.txt").getChannel();
        ) {
            // 3 将FileChannel里的全部数据---->映射成ByteBuffer
            MappedByteBuffer buffer = inChannel.map(FileChannel.MapMode.READ_ONLY, 0, f.length()); // ①
            // 4 直接将buffer里的数据全部输出
            outChannel.write(buffer); // ②
            // 5 再次调用buffer的clear()方法，复原limit、position的位置
            buffer.clear();
            // 6 使用UTF-8的字符集来创建解码器
            Charset charset = Charset.forName("UTF-8");
            // 7 创建解码器(CharsetDecoder)对象
            CharsetDecoder decoder = charset.newDecoder();
            // 8 使用解码器将ByteBuffer转换成CharBuffer
            CharBuffer charBuffer = decoder.decode(buffer);
            // 9 CharBuffer的toString方法可以获取对应的字符串
            System.out.println(charBuffer);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
