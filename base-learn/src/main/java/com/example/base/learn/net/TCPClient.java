package com.example.base.learn.net;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 * Created  on 2023/8/4 09:9:22
 *
 * @author zl
 */
public class TCPClient {

    public static void main(String[] args) throws IOException {
        //创建发送端Socket对象（创建连接）
        Socket s = new Socket(InetAddress.getByName("192.168.1.65"), 10086);
        //获取输出流对象
        OutputStream os = s.getOutputStream();
        //发送数据
        String str = "hello tcp,im coming!!!";
        os.write(str.getBytes());
        //释放资源
        //os.close();
        s.close();
    }
}
