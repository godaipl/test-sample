package com.china.test.sample.tsapi.controller;

import com.china.test.sample.tsapi.resp.BaseResp;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 这是一个测试controller
 *
 * @author yandongjun
 */
@RestController
@RequestMapping("test")
public class TestController {

    // http://localhost:8889/ts/test/getSomething
    @GetMapping("getSomething")
    public BaseResp<?> getSomething() {
        return BaseResp.newBuilder().setCodeAndMsg("200", "OK");
    }
}
