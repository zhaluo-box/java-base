package com.zhaluobox.crazyjava.chapter06.chapter06_09_枚举类.exercise;

public enum TransStatusEnum {

    F("FAIL", "失败"), S("SUCCESS", "成功"), R("READ", "准备"), B("BEGIN", "开始");
    private String name;
    private String value;


    TransStatusEnum(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public static void main(String[] args) {
        System.out.println(TransStatusEnum.B.name);
        System.out.println(TransStatusEnum.B.value);
    }
}
