package com.example.base.learn.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * TCP 严格区分客户端&服务端
 * Created  on 2023/8/4 09:9:23
 *
 * @author zl
 */
public class TCPServer {

    public static void main(String[] args) throws IOException {
        //创建服务器端Socket对象
        ServerSocket ss = new ServerSocket(10086);
        //监听
        Socket s = ss.accept();
        //获取输入流对象
        BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
        //获取用户名和密码
        String username = br.readLine();
        String password = br.readLine();
        //判断用户名和密码是否正确
        boolean flag = false;

        List<User> users = UserDB.getUsers();
        User user = new User(username, password);
        if (users.contains(user)) {
            //匹配成功
            flag = true;
        }

        //获取输出流对象
        PrintWriter out = new PrintWriter(s.getOutputStream(), true);

        //返回判断信息
        if (flag) {
            out.println("登陆成功");
        } else {
            out.println("登陆失败");
        }
        //释放资源
        s.close();
        //ss.close();//服务器一般不关闭
    }

    public static class UserDB {

        public static List<User> getUsers() {
            List<User> users = new ArrayList<>();
            users.add(new User("zs", "123456"));
            return users;
        }
    }
}
