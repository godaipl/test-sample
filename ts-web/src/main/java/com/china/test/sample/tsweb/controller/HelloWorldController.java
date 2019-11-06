package com.china.test.sample.tsweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * @author yandongjun
 */
@Controller
@RequestMapping("/web")
public class HelloWorldController {
    /**
     * 返回html模板.
     */
    @RequestMapping("/HelloWorld")
    public String HelloWorld(Map<String, Object> map) {
        map.put("HelloWorld", "from HelloWorldController.HelloWorld");
        return "/HelloWorld";
    }

}
