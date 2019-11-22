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
        // 这里的HelloWorld是与模板文件中的 ${HelloWorld} 对应的，最后会被这段话替换掉
        map.put("HelloWorld", "这里的HelloWorld是与模板文件中的 ${HelloWorld} 对应的，最后会被这段话的替换掉");
        // 这里返回的值是templates目录下的文件名，不要带后文件后缀名
        return "HelloWorld";
    }

}
