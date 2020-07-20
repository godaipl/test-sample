package com.china.test.sample.tsapi.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.china.test.sample.tsapi.req.MomoGiftReq;
import com.china.test.sample.tsapi.resp.BaseResp;
import org.springframework.web.bind.annotation.*;

import lombok.extern.slf4j.Slf4j;

/**
 * 这是一个测试controller
 *
 * @author yandongjun
 */
@RestController
@RequestMapping("test")
@Slf4j
public class TestController {
    /**
     * http://ip:port/ts/test/
     * 
     * @return
     */
    @RequestMapping("/")
    public String get() {
        return "单url";
    }

    /**
     * http://ip:port/ts/test/ http://ip:port/ts/test/get
     * http://ip:port/ts/test/get1 http://ip:port/ts/test/get2
     * 
     * @return
     */
    @RequestMapping(path = { "get", "get1", "get2" })
    public String get0() {
        return "多url";
    }

    /**
     * http://localhost:8889/ts/test/getValueById?id=1
     * 
     * @param testId
     * @return
     */
    @RequestMapping(path = "getValueById")
    public String getValueById(@RequestParam("id") String testId) {
        return "如果参数名和参数名不一样，需要特殊标明，testId is " + testId;
    }

    /**
     * http://localhost:8889/ts/test/getValueById2?testId=1
     * 
     * @param testId
     * @return
     */
    @RequestMapping(path = "getValueById2")
    public String getValueById2(@RequestParam String testId) {
        return "如果说参数和变量名一样就不用写别名，testId is " + testId;
    }

    /**
     * required 如果是true 表明这个参数必须带 defaultValue 表示如果不传值，这个参数就是这个值
     * http://localhost:8889/ts/test/getValueById3?id=1
     * 
     * @param testId
     * @return
     */
    @RequestMapping(path = "getValueById3")
    public String getValueById3(@RequestParam(value = "id", required = true, defaultValue = "-1") String testId) {
        return "required defaultValue 的使用，testId is " + testId;
    }

    /**
     * HTTP GET
     * 
     * @return
     */
    @RequestMapping(path = "methodGet", method = RequestMethod.GET)
    public String methodGet() {
        return "HTTP GET ";
    }

    /**
     * HTTP POST
     * 
     * @return
     */
    @RequestMapping(path = "methodPost", method = RequestMethod.POST)
    public String methodPost() {
        return "HTTP POST ";
    }

    /**
     * HTTP DELETE
     * 
     * @return
     */
    @RequestMapping(path = "methodDelete", method = RequestMethod.DELETE)
    public String methodDelete() {
        return "HTTP DELETE ";
    }

    /**
     * 常用的method有Get Post Delete等，具体的区别自行百度 http://ip:port/ts/test/getSomething
     *
     * @return
     */
    @RequestMapping(path = "getSomething", method = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE })
    public BaseResp<?> getSomething() {
        return BaseResp.newBuilder().setCodeAndMsg("200", "OK");
    }

    /**
     * 这是一个Get接口，如果明确了method就直接写相应的Mapping http://ip:port/ts/test/getHelloWorld
     *
     * @return String 返回字符串结果
     */
    @GetMapping(path = "getHelloWorld")
    public String getHelloWorld() {
        return "HTTP GET";
    }

    /**
     * 这是一个Post接口，如果明确了method就直接写相应的Mapping http://ip:port/ts/test/updateHelloWorld
     *
     * @return String 返回字符串结果
     */
    @PostMapping(path = "postHelloWorld")
    public String postHelloWorld() {
        return "HTTP POST";
    }

    /**
     * 这是一个Post接口，如果明确了method就直接写相应的Mapping http://ip:port/ts/test/deleteHelloWorld
     *
     * @return
     */
    @DeleteMapping(path = "deleteHelloWorld")
    public String deleteHelloWorld() {
        return "HTTP DELETE";
    }

    /**
     * 这是一个通过url来取参的restful api
     * 
     * @param map
     * @return
     */
    @RequestMapping(path = "get/userInfo/{userId}")
    // @RequestMapping(value = "/get/userInfo/{userId}")
    @ResponseBody
    public String getUserInfoById(@PathVariable(value = "userId") Integer userId) {
        log.info("getUserInfoById userId is {}", userId);
        return "OK";
    }

    /**
     * 下面我们来讲一下body传参的方法
     * 
     * @param map 具体参数
     * @return
     */
    @PostMapping(path = "getMomoGifts", consumes = "application/json")
    @ResponseBody
    @SuppressWarnings("unchecked")
    public BaseResp<List<Object>> getMomoGifts(@RequestBody Map<String, Object> map) {
        log.info("getMomoGifts map is {}", map);
        BaseResp<List<Object>> baseResp = (BaseResp<List<Object>>) BaseResp.newBuilder().setCodeAndMsg("0", "OK");
        List<Object> objects = new ArrayList<>();
        objects.add("a");
        objects.add("b");
        objects.add("c");
        baseResp.setResult(objects);
        return baseResp;
    }

    /**
     * 下面我们来讲一下body传参的方法2
     * 
     * @param MomoGiftReq 用一个对象来接收传入的json参数
     * @return
     */
    @PostMapping(path = "getMomoGifts2", consumes = "application/json")
    @ResponseBody
    @SuppressWarnings("unchecked")
    public BaseResp<List<Object>> getMomoGifts2(@RequestBody MomoGiftReq momoGiftReq) {
        log.info("getMomoGifts momoGiftReq is {}", momoGiftReq);
        BaseResp<List<Object>> baseResp = (BaseResp<List<Object>>) BaseResp.newBuilder().setCodeAndMsg("0", "OK");
        List<Object> objects = new ArrayList<>();
        objects.add("a");
        objects.add("b");
        objects.add("c");
        baseResp.setResult(objects);
        return baseResp;
    }
}
