package com.example.learn.pattern.behavioral;

import java.util.Map;

/**
 * Created  on 2023/5/25 16:16:25
 *
 * @author zl
 */
public class DefaultSysOperationLogService extends AbstractSysOperatorLogService {

    @Override
    protected void saveBefore(Map<String, Object> log) {
        log.put("default", "DefaultSysOperationLogService");
    }

    @Override
    protected SysOperationLogService getSysOperationLogService() {
        return this;
    }

    @Override
    public void save(Map<String, Object> log) {
        System.out.println("log = " + log);
    }
}
