package com.china.test.sample.tsmain.mongodb;

import com.china.test.sample.tsdao.mongodb.test.domain.Demo;
import com.china.test.sample.tsmain.BaseJunitTest;
import com.china.test.sample.tsservice.service.DemoService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

/**
 * mongodb连接示例
 * <p>
 * https://cloud.mongodb.com/
 * account:godaipl
 * pass:yandongjun
 */
@Slf4j
public class TestMongoDemo extends BaseJunitTest {
    @Autowired
    DemoService demoService;

    /**
     * 这个测试类用于查询所有名字是bobo_test的Demo
     *
     * @throws Exception
     */
    @Test
    public void testQueryDemos() {
        log.info("返回的数据是 {}", demoService.findDemosByName("bobo_test"));
    }

    @Test
    public void addDemo() {
        Demo demo = new Demo();
        demo.setName("bobo_test");
        demo.setAge(18);
        demo.setSalary(new BigDecimal("11.11"));
        Demo retDemo = demoService.addDemo(demo);
        log.info("数据添加好了 {}", retDemo);
    }

    @Test
    public void delDemo() {
        // 1. 找出你要删除的demo
        Demo demo = demoService.findDemoByName("bobo_test");

        if (null != demo) {
            log.info("要删除的数据是 {}", demo);
            // 2. 删除demo，底层用的是demo的id进行删除
            demoService.delDemo(demo);
            log.info("删除成功 {}", demo);
        } else {
            log.info("未找到demo");
        }
        
    }

    @Test
    public void updateDemo() {
        Demo demo = new Demo();
        demo.setName("bobo_test");
        demo.setAge(50);
        Demo updatedDemo = demoService.updateDemo(demo);
        log.info("更新之后的结果是: {}", updatedDemo);
    }
}
