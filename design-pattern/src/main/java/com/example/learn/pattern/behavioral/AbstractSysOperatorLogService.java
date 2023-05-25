package com.example.learn.pattern.behavioral;

import java.util.Map;

/**
 * Created  on 2023/5/25 16:16:23
 *
 * @author zl
 */
public abstract class AbstractSysOperatorLogService implements SysOperationLogService {

    protected abstract void saveBefore(Map<String, Object> log);

    protected abstract SysOperationLogService getSysOperationLogService();

    public void HandlerLog(Map<String, Object> log) {
        saveBefore(log);
        save(log);
    }
}
