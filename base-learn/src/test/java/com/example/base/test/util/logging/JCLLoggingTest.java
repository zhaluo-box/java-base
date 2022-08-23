package com.example.base.test.util.logging;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * JCL Apache Common Logging  Facade  test
 * JCL 在找不到日志实现框架的情况下 会找JDK 自身的日志实现
 * Created  on 2022/8/23 17:17:00
 *
 * @author zl
 */
public class JCLLoggingTest {

    static final Log log = LogFactory.getLog(JCLLoggingTest.class);

    @Test
    @DisplayName("JCL 日志测试")
    public void loggingTest() {
        log.info("JCL log facade test");
        log.warn("log impl is jdk logging");
    }
}
