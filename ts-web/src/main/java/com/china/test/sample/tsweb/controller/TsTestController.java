package com.china.test.sample.tsweb.controller;

import com.china.test.sample.tsdao.tsdb.domain.TsTest;
import com.china.test.sample.tsweb.service.TsTestService;
import com.china.test.sample.tsweb.views.TsTestVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Map;

/**
 * @author yandongjun
 */
@Controller
@RequestMapping("/tsTest")
@Slf4j
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

    /**
     * 我们使用数据库查询作为本次增删改查的数据来源
     * 
     * http://localhost:8889/ts/tsTest/CrudTemplate
     */
    @RequestMapping("/CrudTemplate")
    public String crudTemplate(Model model) {
        List<TsTest> tsTests = tsTestService.getTsTestListForCrudTemplate();
        model.addAttribute("tsTests", tsTests);
        // 这里返回的值是templates目录下的文件名，不要带后文件后缀名
        return "CrudTemplate";
    }

    /**
     * 我们使用数据库查询作为本次增删改查的数据来源
     * 
     * http://localhost:8889/ts/tsTest/jumpToAddPage
     */
    @RequestMapping("/jumpToAddPage")
    public ModelAndView addTemplate(Model model) {
        model.addAttribute("tsTest", new TsTest());
        model.addAttribute("title", "添加用户");
        return new ModelAndView("AddTemplate", "tsTestModel", model);
    }

    /**
     * 功能描述 添加用户
     * 
     * @author qqg
     * @date
     * @param * @param user
     * @return
     */
    @PostMapping("/addTsTest")
    public ModelAndView addTsTest(TsTest tsTest) {
        log.info("addTsTest {}", tsTest);

        String tips = null;
        // 保存数据至数据库
        if (tsTestService.addTsTest(tsTest) > 0) {
            log.info("add success");
            tips = "添加数据成功";
        } else {
            log.info("add fail");
            tips = "添加数据失败";
        }

        // 保存完之后跳转至展示页面, 这里不用带项目名
        return new ModelAndView("redirect:/tsTest/CrudTemplate", "tips", tips);
    }

    public void addTsTest() {
        TsTest tsTest = new TsTest();
        tsTest.setUserName("test");
        tsTest.setAge(1);

        tsTestService.addTsTest(tsTest);
    }

    /**
     * 功能描述 添加用户
     * 
     * @author qqg
     * @date
     * @param * @param user
     * @return
     */
    @GetMapping("/delTsTest/{id}")
    public ModelAndView delTsTest(@PathVariable("id") Integer id) {
        log.info("delTsTest {}", id);

        String tips = null;
        // 保存数据至数据库
        if (tsTestService.delTsTest(id) > 0) {
            log.info("del success");
            tips = "删除数据成功";
        } else {
            log.info("del fail");
            tips = "删除数据失败";
        }

        // 保存完之后跳转至展示页面, 这里不用带项目名
        return new ModelAndView("redirect:/tsTest/CrudTemplate", "tips", tips);
    }

    /**
     * 功能描述 跳转至用户修改页面z
     * 
     * @author yandongjun
     * @date
     * @param * @param user
     * @return
     */
    @GetMapping("/jumpToEditPage/{id}")
    public ModelAndView jumpToEditPage(Model model, @PathVariable("id") Integer id) {
        log.info("editTsTest {}", id);

        // 编辑时，需要将原有的数据进行展示，我们也可能通过页面把数据传递到这来处理
        TsTest tsTest = tsTestService.getTsTest(id);
        // 推荐查询数据的数据
        model.addAttribute("tsTest", tsTest);
        model.addAttribute("title", "这是一个编辑展示页面");

        // 保存完之后跳转至展示页面, 这里不用带项目名
        return new ModelAndView("EditTemplate", "tsTestModel", model);
    }

       /**
     * 功能描述 添加用户
     * 
     * @author qqg
     * @date
     * @param * @param user
     * @return
     */
    @PostMapping("/editTsTest")
    public ModelAndView editTsTest(TsTest tsTest) {
        log.info("editTsTest {}", tsTest);

        String tips = null;
        // 保存数据至数据库
        if (tsTestService.editTsTest(tsTest) > 0) {
            log.info("edit success");
            tips = "更新数据成功";
        } else {
            log.info("edit fail");
            tips = "更新数据失败";
        }

        // 保存完之后跳转至展示页面, 这里不用带项目名
        return new ModelAndView("redirect:/tsTest/CrudTemplate", "tips", tips);
    }
}
