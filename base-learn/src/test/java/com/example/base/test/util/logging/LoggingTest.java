package com.example.base.test.util.logging;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created  on 2022/8/23 16:16:05
 *
 * @author zl
 */
public class LoggingTest {

    @Test
    @DisplayName("测试Java 提供的日志实现")
    public void nativeLoggingTest() {

        var logger = Logger.getGlobal();
        logger.setLevel(Level.INFO);

        logger.info("java native logging info level test");
        logger.warning("java native logging warning level test");
        logger.severe("java native logging SEVERE level test");
        logger.log(Level.SEVERE, "java native logging SEVERE level test");

    }
}
