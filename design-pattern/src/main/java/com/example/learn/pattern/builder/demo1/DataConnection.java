package com.example.learn.pattern.builder.demo1;

import lombok.ToString;

/**
 * Created  on 2023/8/15 23:23:06
 *
 * @author zl
 */
@ToString
public class DataConnection implements DS1 {

    /**
     * 驱动
     */
    private String driver;

    private String host;

    private int port;

    private String username;

    private String password;

    public DataConnection() {
    }

    public DataConnection(String driver, String host, int port, String username, String password) {
        this.driver = driver;
        this.host = host;
        this.port = port;
        this.username = username;
        this.password = password;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
