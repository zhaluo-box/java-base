package com.example.learn.pattern.proxyModel.proxyModel3.staticproxy;

/**
 * 玩家接口
 */
public interface IGamePlayer {
    // 登录
    void login(String user,String password);
    // 打怪
    void  killBoss();
    // 升级
    void upGrade();
}
