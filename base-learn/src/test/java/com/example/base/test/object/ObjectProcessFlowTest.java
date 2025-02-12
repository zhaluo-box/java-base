package com.example.base.test.object;

import com.example.base.learn.object.OrdinaryObjectProcessFlow;
import com.example.base.learn.object.SubObjectProcessFlow;
import org.junit.jupiter.api.Test;

/**
 * 测试类的加载顺序
 * Created  on 2022/3/17 11:11:55
 *
 * @author zl
 */
public class ObjectProcessFlowTest {

    /**
     * 测试普通对象的执行流程
     */
    @Test
    public void test() {
        OrdinaryObjectProcessFlow processFlow = new OrdinaryObjectProcessFlow();
    }

    @Test
    public void subObjectProcessTest() {
        SubObjectProcessFlow subObjectProcessFlow = new SubObjectProcessFlow();
    }

}
