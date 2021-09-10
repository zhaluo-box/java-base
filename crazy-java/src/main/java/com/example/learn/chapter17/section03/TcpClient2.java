package com.zhaluobox.crazyjava.chapter17.section03;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class TcpClient2 {
    public static void main(String[] args) throws IOException {
        //创建发送端Socket对象（创建连接）
        Socket s = new Socket(InetAddress.getByName("172.24.107.220"), 10022);
        //获取输出流对象,向服务端输出
        OutputStream os = s.getOutputStream();
        //准备数据,发送数据
        String str = "hello tcp 协议,我来了";
        os.write(str.getBytes());

        //获取输入流对象,准备接受数据
        InputStream is = s.getInputStream();
        byte[] bys = new byte[1024];
        int len;//用于存储读取到的字节个数
        //接收数据
        while ((len = is.read(bys)) != -1) {
            //输出数据
            System.out.println(new String(bys, 0, len));
        }
        //释放资源
        //os.close();
        s.close();
    }
}
