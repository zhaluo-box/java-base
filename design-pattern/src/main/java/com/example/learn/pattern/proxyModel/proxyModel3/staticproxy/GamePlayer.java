package com.example.learn.pattern.proxyModel.proxyModel3.staticproxy;

import lombok.extern.slf4j.Slf4j;

/**
 * 游戏玩家
 *
 * @author 扎罗
 * @version 1.0.0
 * @Date 2020-9-23 10:05
 */
@Slf4j
public class GamePlayer implements IGamePlayer {

    private String name = ""; //通过构造函数传递名称

    public GamePlayer(String _name) {
        this.name = _name;
    }

    @Override
    public void login(String user, String password) {
        log.info( "登录名: {}, 密码: {}", this.name, password );
    }

    @Override
    public void killBoss() {
        log.info( "{} 在打怪", this.name );
    }

    @Override
    public void upGrade() {
        log.info( "{} 在升级", this.name );
    }
}
