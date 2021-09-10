package com.example.learn.pattern.proxyModel.proxyModel3.staticproxy;

/**
 * 场景类
 *
 * @author 扎罗
 * @version 1.0.0
 * @Date 2020-9-23 10:14
 */
public class Client {

    public static void main(String[] args) {
        System.out.println("自己游戏");
        gamePlay();
        System.out.println("请代理");
        proxyTest();
    }

    /**
     * 不用代理
     */
    private static void gamePlay() {
        //  玩家
        IGamePlayer gamePlayer = new GamePlayer( "张三" );
        // 时间戳
        System.out.println( System.currentTimeMillis() );
        // 登录
        gamePlayer.login( "张三", "pwd" );
        // 打怪
        gamePlayer.killBoss();
        // 升级
        gamePlayer.upGrade();
        // 时间戳
        System.out.println( System.currentTimeMillis() );
    }

    /**
     * 代理
     * @version 1.0.0
     */
    public  static void proxyTest(){
        IGamePlayer gamePlayer = new GamePlayer( "张三" );
        final GamePlayerProxy playerProxy = new GamePlayerProxy( gamePlayer );
        // 登录
        playerProxy.login( "张三","pwd" );
        // 打怪
        playerProxy.killBoss();
        // 升级
        playerProxy.upGrade();
    }
}
