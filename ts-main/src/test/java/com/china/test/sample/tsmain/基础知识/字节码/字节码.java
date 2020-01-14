package com.china.test.sample.tsmain.基础知识.字节码;

/**
 * 字节码
 */
public class 字节码 {
    short aShort = 1;
    int aInt = 2;
    double aDouble = 3;
    long aLong = 4;
    String aString = "5";

    public int getAdd() {
        return aShort + aInt;
    }
}

class 字节码B extends 字节码 {
    public int getSub() {
        return aShort - aInt;
    }
}
