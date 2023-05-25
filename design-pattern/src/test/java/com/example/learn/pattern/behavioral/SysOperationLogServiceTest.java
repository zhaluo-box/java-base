package com.example.learn.pattern.behavioral;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

/**
 * Created  on 2023/5/25 16:16:27
 *
 * @author zl
 */
class SysOperationLogServiceTest {

    @Test
    @DisplayName("委派模式测试")
    void save() {

        AbstractSysOperatorLogService service = new DefaultSysOperationLogService();

        var map = new HashMap<String, Object>();
        map.put("test", 123);
        service.save(map);

    }
}
