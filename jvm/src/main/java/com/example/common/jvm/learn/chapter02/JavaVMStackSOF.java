package com.example.common.jvm.learn.chapter02;

/**
 * 虚拟机栈 和本地方法栈 OOM 测试
 */
public class JavaVMStackSOF {
    private int stackLength = 1;

    /**
     * 递归调用
     */
    public void stackLeak() {
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) {
        JavaVMStackSOF stackSOF = new JavaVMStackSOF();

        try {
            stackSOF.stackLeak();
        } catch (Throwable e) {
            System.out.println("stack length : " + stackSOF.stackLength);
            throw e;
        }
    }

}
