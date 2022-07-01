package com.example.learn.pattern.structural.proxy.demo1.bussiness;

/**
 * 登录业务
 * Created  on 2022/6/2 09:9:42
 *
 * @author zl
 */
public interface LogService {

    /**
     * 登入
     *
     * @param username 用户名
     * @param password 密码
     */
    String login(String username, String password);

    /**
     * 登出
     *
     * @param username 用户名
     */
    String logout(String username);
}
