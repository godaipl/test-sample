package com.china.test.sample.tsweb.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.china.test.sample.tsdao.tsdb.domain.TsTest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author yandongjun
 */
@Controller
@RequestMapping("/tsTest")
public class TsTestController {
    /**
     * http://localhost:8889/ts/tsTest/ShowTestInfo
     */
    @RequestMapping("/ShowTestInfo")
    public String ShowTestInfo(Map<String, Object> map) {
        List<TsTest> tsTests = getTsTests();
        // model.addAttribute("tsTests", tsTests);
        map.put("tsTests", tsTests);
        // 这里返回的值是templates目录下的文件名，不要带后文件后缀名
        return "ShowTestInfo";
    }

    /**
     * 使用model，最后SpringBoot会将model转成map(具体可以看接口Model的asMap方法)，和上面的方法一样
     * 
     * http://localhost:8889/ts/tsTest/ShowTestInfo2
     */
    @RequestMapping("/ShowTestInfo2")
    public String ShowTestInfo2(Model model) {
        List<TsTest> tsTests = getTsTests();
        model.addAttribute("tsTests", tsTests);
        // 这里返回的值是templates目录下的文件名，不要带后文件后缀名
        return "ShowTestInfo";
    }

    /**
     * 我们从数据库中获取数据并展示
     * 
     * 1. 使用service层的方法获取数据
     * 
     * 2. service层将获取的结果数据转换成前端展示类TsTestVO(view)
     * 
     * 3. service层方法调用dao层方法获取数据
     * 
     * 4. dao层其实就是我们的mapper类
     * 
     * http://localhost:8889/ts/tsTest/ShowTestInfo3
     */
    @RequestMapping("/ShowTestInfo3")
    public String ShowTestInfo3(Model model) {
        List<TsTest> tsTests = getTsTests();
        model.addAttribute("tsTests", tsTests);
        return "ShowTestInfo";
    }

    /**
     * 写一个方法用于获取展示数据
     * 
     * @return
     */
    private List<TsTest> getTsTests() {
        List<TsTest> tsTests = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            TsTest test = new TsTest();
            test.setId(i);
            test.setUserName("username" + i);
            test.setAge(i + 10);
            tsTests.add(test);
        }

        return tsTests;
    }
}
