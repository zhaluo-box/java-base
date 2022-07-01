package com.example.learn.pattern.structural.proxy.demo1.bussiness;

/**
 * Created  on 2022/6/2 10:10:35
 *
 * @author zl
 */
public class DefaultLogService implements LogService {
    @Override
    public String login(String username, String password) {

        return String.format("%s-%s", username, password);

    }

    @Override
    public String logout(String username) {
        return String.format("用户：%s， %s", username, "已登出");
    }
}
