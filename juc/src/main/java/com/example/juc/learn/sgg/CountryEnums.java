package com.example.juc.learn.sgg;

public enum CountryEnums {


    ONE(1, "赵国"),
    TWO(2, "魏国"),
    THREE(3, "韩国"),
    FOUR(4, "齐国"),
    FIVE(5, "燕国"),
    SIX(6, "楚国"),
    SEVEN(7, "秦国");

    private Integer retCode;

    private String retMsg;

    CountryEnums(Integer retCode, String retMsg) {
        this.retCode = retCode;
        this.retMsg = retMsg;
    }


    public Integer getretCode() {
        return retCode;
    }

    public void setretCode(Integer retCode) {
        this.retCode = retCode;
    }

    public String getretMsg() {
        return retMsg;
    }

    public void setretMsg(String retMsg) {
        this.retMsg = retMsg;
    }

    public static CountryEnums forEachCountryEnums(Integer i) {
        for (CountryEnums c : values()) {
            if (c.getretCode() == i) {
                return c;
            }
        }
        return null;
    }
}
