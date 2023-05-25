package com.example.learn.pattern.behavioral;

import java.util.Map;

/**
 * Created  on 2023/5/25 16:16:22
 *
 * @author zl
 */
public interface SysOperationLogService {

    void save(Map<String, Object> log);

}
