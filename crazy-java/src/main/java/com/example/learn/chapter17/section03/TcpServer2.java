package com.zhaluobox.crazyjava.chapter17.section03;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer2 {
    public static void main(String[] args) throws IOException {
        //创建接收端Socket对象
        ServerSocket ss = new ServerSocket(10022);
        //监听（阻塞）
        Socket s = ss.accept();
        //获取输入流对象
        InputStream is = s.getInputStream();
        // 获取输出流对象
        final OutputStream os = s.getOutputStream();
        //获取数据
        byte[] bys = new byte[1024];
        int len;//用于存储读到的字节个数
        InetAddress address = s.getInetAddress();
        System.out.println("client ---> " + address.getHostName());
        int i=1;
        while ((len = is.read(bys)) != -1) {
            //输出数据
            System.out.println(new String(bys, 0, len));
//            os.write(new String(bys, 0, len).toUpperCase().getBytes());

            os.write(new String("来就来了"+(i++)).getBytes());
        }

        //释放资源
        s.close();
        //ss.close();
    }
}
