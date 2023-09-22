package com.example.learn.pattern.builder.demo1;

import java.util.Objects;

/**
 * 本质工作，构建一个DataConnection
 * Created  on 2023/8/15 23:23:13
 *
 * @author zl
 */

public class DataConnectionBuilder {

    String driver;

    String host;

    int port;

    String username;

    String password;

    public DataConnectionBuilder driver(String driver) {
        this.driver = driver;
        return this;
    }

    public DataConnectionBuilder setHost(String host) {
        this.host = host;
        return this;
    }

    public DataConnectionBuilder setPort(int port) {
        this.port = port;
        return this;
    }

    public DataConnectionBuilder setUsername(String username) {
        // 校验
        if (this.username != null) {
            throw new RuntimeException("用户名只能设置一个");
        }
        this.username = username;
        return this;
    }

    public DataConnectionBuilder setPassword(String password) {
        this.password = password;
        return this;
    }

    public DataConnectionBuilder() {
    }

    /**
     * 可以进行数据完整性的校验
     *
     * @return 构造者 的本质工作，并不是为了返回一个自己，而是构建一个特定的对象，并保障这个对象的安全与完整性 与他的返回值有关系
     */
    public DataConnection build() {

        //1. driver 必须是 mysql 其中的一种，如果是其他的就无法构建

        if (!(this.driver != null && "com.mysql.driver".equalsIgnoreCase(this.driver))) {
            throw new RuntimeException("当前数据库只支持MySQL");
        }

        //2. 验证数据的完整性
        if (Objects.isNull(this.host)) {
            throw new RuntimeException("host not allow null!");
        }
        // ..省略其他校验

        DataConnection dataConnection = new DataConnection();

        dataConnection.setHost(this.host);
        dataConnection.setDriver(this.driver);
        dataConnection.setPort(this.port);
        dataConnection.setUsername(this.username);
        dataConnection.setPassword(this.password);

        return dataConnection;
    }

    public DS1 buildDS() {

        //1. driver 必须是 mysql 其中的一种，如果是其他的就无法构建

        if (!(this.driver != null && "com.mysql.driver".equalsIgnoreCase(this.driver))) {
            throw new RuntimeException("当前数据库只支持MySQL");
        }

        //2. 验证数据的完整性
        if (Objects.isNull(this.host)) {
            throw new RuntimeException("host not allow null!");
        }
        // ..省略其他校验

        DataConnection dataConnection = new DataConnection();

        dataConnection.setHost(this.host);
        dataConnection.setDriver(this.driver);
        dataConnection.setPort(this.port);
        dataConnection.setUsername(this.username);
        dataConnection.setPassword(this.password);

        return dataConnection;
    }

}
