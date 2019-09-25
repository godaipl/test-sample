package com.china.test.sample.tsapi.req;

import java.io.Serializable;

import lombok.Data;

/**
 * 全局基础的请求类，默认只定义序列化和一些共用字段
 * 加了Data注解，就不用写get set toString方法了
 */
@Data
public class BaseReq implements Serializable {

    /**
     * 这是所有实现Serializable 都需要加的字段，具体为什么要加这个，我们可以看这一篇文章(中高级程序员要求)
     * https://blog.csdn.net/u014750606/article/details/80040130
     */
    private static final long serialVersionUID = 6457310313653390319L;

    /**
     * 这里作一个示范，放一个基础的消息
     */
    private String baseMsg;
}