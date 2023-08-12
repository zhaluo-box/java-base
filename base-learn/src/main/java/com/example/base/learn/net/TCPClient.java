package com.example.base.learn.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created  on 2023/8/4 09:9:22
 *
 * @author zl
 */
public class TCPClient {

    public static void main(String[] args) throws IOException {
        //创建客户端Socket对象
        Socket s = new Socket("192.168.1.65", 10086);

        //创建客户端Socket对象

        //获取用户名和密码
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("请输入用户名:");
        String username = br.readLine();
        System.out.println("请输入密码:");
        String password = br.readLine();

        //获取输出流对象
        PrintWriter out = new PrintWriter(s.getOutputStream(), true);
        //写出数据
        out.println(username);
        out.println(password);

        //获取输入流对象
        BufferedReader serverBr = new BufferedReader(new InputStreamReader(s.getInputStream()));
        //获取服务器返回的数据
        String result = serverBr.readLine();
        System.out.println(result);
        //释放资源
        s.close();
    }
}
