package com.example.common.jvm.learn.chapter02;

/**
 *  JVM 参数 : -Xss2M
 *  运行前注意保存自己电脑的东西..运行系统会假死.需要重启
 */
public class JavaVMStackOOM {

    private void dontStop() {
        while (true) {

        }
    }

    public void stackLeakByThread() {

        while (true) {
            Thread thread = new Thread(() -> {
                dontStop();
            });
            thread.start();
        }
    }

    public static void main(String[] args) {
        JavaVMStackOOM oom = new JavaVMStackOOM();
        oom.stackLeakByThread();
    }
}
