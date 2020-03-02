package com.china.test.sample.tsmain.mongodb;

import com.china.test.sample.tsdao.mongodb.test2.domain.Demo2;
import com.china.test.sample.tsmain.BaseJunitTest;
import com.china.test.sample.tsservice.service.Demo2Service;
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
public class TestMongoDemo2 extends BaseJunitTest {
    @Autowired
    Demo2Service demo2Service;

    /**
     * 这个测试类用于查询所有名字是bobo_test的Demo
     *
     * @throws Exception
     */
    @Test
    public void testQueryDemo2s() {
        log.info("返回的数据是 {}", demo2Service.findDemo2sByName("bobo_test2"));
    }

    @Test
    public void addDemo() {
        Demo2 demo2 = new Demo2();
        demo2.setName2("bobo_test2");
        demo2.setAge2(18);
        demo2.setSalary2(new BigDecimal("11.11"));
        Demo2 retDemo2 = demo2Service.addDemo2(demo2);
        log.info("数据添加好了 {}", retDemo2);
    }

    @Test
    public void delDemo2() {
        // 1. 找出你要删除的demo
        Demo2 demo2 = demo2Service.findDemo2ByName("bobo_test");

        if (null != demo2) {
            log.info("要删除的数据是 {}", demo2);
            // 2. 删除demo，底层用的是demo的id进行删除
            demo2Service.delDemo2(demo2);
            log.info("删除成功 {}", demo2);
        } else {
            log.info("未找到demo");
        }

    }

    @Test
    public void updateDemo() {
        Demo2 demo2 = new Demo2();
        demo2.setName2("bobo_test");
        demo2.setAge2(50);
        Demo2 updatedDemo2 = demo2Service.updateDemo2(demo2);
        log.info("更新之后的结果是: {}", updatedDemo2);
    }
}
