package com.china.test.sample.tsweb.controller;

import com.china.test.sample.tsweb.service.TsTestService;
import com.china.test.sample.tsweb.views.TsTestVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

/**
 * @author yandongjun
 */
@Controller
@RequestMapping("/tsTest")
public class TsTestController {
    @Autowired
    TsTestService tsTestService;

    /**
     * http://localhost:8889/ts/tsTest/ShowTestInfo
     */
    @RequestMapping("/ShowTestInfo")
    public String ShowTestInfo(Map<String, Object> map) {
        List<TsTestVO> tsTestVOs = tsTestService.getTsTestVOListForShowTestInfo();
        map.put("tsTestVOs", tsTestVOs);
        // 这里返回的值是templates目录下的文件名，不要带后文件后缀名
        return "ShowTestInfo";
    }

    /**
     * 使用model，最后SpringBoot会将model转成map(具体可以看接口Model的asMap方法)，和上面的方法一样
     * <p>
     * http://localhost:8889/ts/tsTest/ShowTestInfo2
     */
    @RequestMapping("/ShowTestInfo2")
    public String ShowTestInfo2(Model model) {
        List<TsTestVO> tsTestVOs = tsTestService.getTsTestVOListForShowTestInfo();
        model.addAttribute("tsTestVOs", tsTestVOs);
        // 这里返回的值是templates目录下的文件名，不要带后文件后缀名
        return "ShowTestInfo";
    }

    /**
     * 我们从数据库中获取数据并展示
     * <p>
     * 1. 使用service层的方法获取数据
     * <p>
     * 2. service层将获取的结果数据转换成前端展示类TsTestVO(view)
     * <p>
     * 3. service层方法调用dao层方法获取数据
     * <p>
     * 4. dao层其实就是我们的mapper类
     * <p>
     * http://localhost:8889/ts/tsTest/ShowTestInfo3
     */
    @RequestMapping("/ShowTestInfo3")
    public String ShowTestInfo3(Model model) {
        List<TsTestVO> tsTestVOs = tsTestService.getTsTestVOListForShowTestInfo3();
        model.addAttribute("tsTestVOs", tsTestVOs);
        // 这里返回的值是templates目录下的文件名，不要带后文件后缀名
        return "ShowTestInfo";
    }
}
