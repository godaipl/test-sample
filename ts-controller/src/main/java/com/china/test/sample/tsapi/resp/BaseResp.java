package com.china.test.sample.tsapi.resp;

import java.io.Serializable;

import lombok.Data;

/**
 * 定义全局基础响应类
 *
 * @author yandongjun
 */
@Data
public class BaseResp<T> implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 2850475854211592729L;

    private String code;

    private String msg;

    private T result;

    public static BaseResp<?> newBuilder() {
        return new BaseResp<>();
    }

    public BaseResp<T> setCodeAndMsg(String code, String msg) {
        this.code = code;
        this.msg = msg;
        return this;
    }

    public BaseResp<T> setCodeAndMsg(String code, String msg, T result) {
        this.code = code;
        this.msg = msg;
        this.result = result;
        return this;
    }
}
