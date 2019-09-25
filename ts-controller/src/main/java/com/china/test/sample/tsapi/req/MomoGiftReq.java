package com.china.test.sample.tsapi.req;

import lombok.Data;

/**
 * 这是一个自定义的请求参数类
 * 加了Data注解，就不用写get set toString方法了
 * 
 * @author yandongjun
 */
@Data
public class MomoGiftReq extends BaseReq {
    /**
     * 添加序列号，为什么要有这个，请查看BaseReq
     */
    private static final long serialVersionUID = 3050854467623386800L;

    /**
     * 用户名
     */
    private String userName;

    /**
     * email信息
     */
    private String age;
}