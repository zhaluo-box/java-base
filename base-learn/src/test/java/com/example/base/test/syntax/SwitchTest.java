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

    public void switchBreak(SwitchEnum type) {
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

    public enum SwitchEnum {
        A, B, C
    }

}
