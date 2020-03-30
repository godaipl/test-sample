package com.china.test.sample.tsmain.基础知识.序列化反序列化;

import lombok.Data;

import java.io.Serializable;

/**
 * 序列化反序列化示例类
 */
@Data
public class PersonNoUID implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = -4342241970829433264L;

    private String userName;

    private String address;

    private int age;

    private String sex;
}
