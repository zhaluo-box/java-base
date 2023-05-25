package com.example.learn.pattern.behavioral;

import java.util.HashMap;

/**
 * Created  on 2023/5/25 16:16:42
 *
 * @author zl
 */
public class SysOperationLogTest {

    public static void main(String[] args) {
        AbstractSysOperatorLogService service = new DefaultSysOperationLogService();

        var map = new HashMap<String, Object>();
        map.put("test", 123);
        service.HandlerLog(map);
    }
}
