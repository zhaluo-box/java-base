package com.example.learn.pattern.structural.proxy.demo1;

import com.example.learn.pattern.structural.proxy.demo1.bussiness.DefaultLogService;
import com.example.learn.pattern.structural.proxy.demo1.bussiness.LogService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Created  on 2023/4/10 16:16:07
 *
 * @author zl
 */
class ProxyFactoryTest {

    @Test
    @DisplayName("代理模式测试")
    void getProxyInstance() {
        var defaultLogService = new DefaultLogService();
        var proxyInstance = (LogService) ProxyFactory.getProxyInstance(defaultLogService, new LogHandler(defaultLogService));

        proxyInstance.login("ZHANGSAN", "123456");

    }
}
