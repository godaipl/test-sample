package com.china.test.sample.tsdao.mongodb.test2.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

/**
 * 这是一个示例类
 *
 * @author yandongjun
 */
@Data
@Document(collection = "demo2")
public class Demo2 {
    /**
     * 默认会有id，一般不用自己这样设置
     */
    @Id
    private String id;

    /**
     * 测试名称
     */
    private String name2;

    /**
     * 测试年龄
     */
    private int age2;

    /**
     * 测试账户余额
     */
    private BigDecimal salary2;
}
