package com.example.base.learn.enums;

/**
 * Created  on 2022/7/1 15:15:17
 *
 * @author zl
 */
public enum EnumProperties {

    MAN("男"), WOMAN("女"), OTHER("其他");

    private final String desc;

    EnumProperties(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return this.desc;
    }

}
