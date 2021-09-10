package com.zhaluobox.crazyjava.chapter17.section03;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class TcpClient {
    public static void main(String[] args) throws IOException {
        //创建发送端Socket对象（创建连接）
        Socket s = new Socket(InetAddress.getByName("172.24.107.220"),10086);
        //获取输出流对象
        OutputStream os = s.getOutputStream();
        //发送数据
        String str = "hello tcp 协议";
        os.write(str.getBytes());
        //释放资源
        //os.close();
        s.close();
    }
}
