package com.example.base.test.util.logging;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.LoggerFactory;

/**
 * Slf4j facade test
 * Created  on 2022/8/23 17:17:07
 *
 * @author zl
 */
public class Slf4jLoggingTest {

    /**
     * 当前测试报错， slf4j-api 只是一个抽象的接口门面层， 需要添加实现的包
     */
    @Test
    @DisplayName("slf4j 日志测试")
    public void loggingTest() {
        var logger = LoggerFactory.getLogger(Slf4jLoggingTest.class);
        logger.info("slf4j log facade test");
    }
}
