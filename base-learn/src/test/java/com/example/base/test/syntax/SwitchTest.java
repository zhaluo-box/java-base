package com.example.base.test.syntax;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

/**
 * Created  on 2022/10/28 09:9:07
 *
 * @author zl
 */
public class SwitchTest {

    @Test
    @DisplayName("switch break 穿透测试")
    public void switchBreakTest() {
        switchBreak(SwitchEnum.C);
        System.out.println("------A, B 会被跳过，因为没有被case---------");
        switchBreak(SwitchEnum.A);
        System.out.println("--------case A 之后会一直向下穿透直到遇到break 跳出-------");
        switchBreak(SwitchEnum.B);
        System.out.println("--------case B 之后会一直向下穿透直到遇到break 跳出-------");
    }

    @Test
    @DisplayName("Switch break 与 method return 测试")
    public void switchBreakAndMethodReturnTest() {
        switchBreakAndMethodReturn(SwitchEnum.B, 3);
    }

    /**
     * 测试结果
     * B0
     * B1
     * B2
     * 提前return method (这里B3 没有打印被提前continue;)
     * B4
     * B5
     */
    @Test
    @DisplayName("Switch break 与 loop continue 测试")
    public void switchBreakAndLoopContinueTest() {
        switchBreakAndLoopContinue(3);
    }

    /**
     * 结果：
     * B0
     * B1
     * 提前 break loop;
     * switch 跳出与循环跳出都是关键字break, 但是循环了起名称标记 可以采用 loopSign: for(){ break:loopSign } 的方式跳出循环
     */
    @Test
    @DisplayName("switch break 与 loop break 测试")
    public void switchBreakAndLoopBreakTest() {
        switchBreakAndLoopBreak(2);
    }

    void switchBreak(SwitchEnum type) {
        switch (type) {
        case A:
            System.out.println("A");
        case B:
            System.out.println("B");
        case C:
            System.out.println("C");
            break;
        default:
            System.out.println("other");
        }
    }

    void switchBreakAndMethodReturn(SwitchEnum type, int signal) {
        switch (type) {
        case A:
            System.out.println("A");
            break;
        case B:
            if (signal == 1) {
                System.out.println("提前return method");
                return;
            }
            System.out.println("B");
            break;
        case C:
            System.out.println("C");
            break;
        default:
            System.out.println("other");
        }
    }

    /**
     * switch break 与循环continue 测试
     */
    void switchBreakAndLoopContinue(int signal) {
        SwitchEnum type = SwitchEnum.B;
        if (signal > 5) {
            throw new RuntimeException("signal 不能大于循环上限 5");
        }
        for (int i = 0; i <= 5; i++) {
            switch (type) {
            case A:
                System.out.println("A" + i);
                break;
            case B:
                if (i == signal) {
                    System.out.println("提前return method");
                    continue;
                }
                System.out.println("B" + i);
                break;
            case C:
                System.out.println("C" + i);
                break;
            default:
                System.out.println("other");
            }
        }
    }

    void switchBreakAndLoopBreak(int signal) {
        SwitchEnum type = SwitchEnum.B;
        if (signal > 5) {
            throw new RuntimeException("signal 不能大于循环上限 5");
        }
        loop:
        for (int i = 0; i <= 5; i++) {
            switch (type) {
            case A:
                System.out.println("A" + i);
                break;
            case B:
                if (i == signal) {
                    System.out.println("提前 break loop;");
                    break loop;
                }
                System.out.println("B" + i);
                break;
            case C:
                System.out.println("C" + i);
                break;
            default:
                System.out.println("other");
            }
        }
    }

    enum SwitchEnum {
        A, B, C
    }

}
