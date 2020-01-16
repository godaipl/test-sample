package com.china.test.sample.tsmain;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.china.test.sample.tsmain.bo.TestEqualsFatherBO;
import com.china.test.sample.tsmain.bo.TestEqualsSonBO;
import com.china.test.sample.tsmain.bo.test.TestEquals;
import com.china.test.sample.tsmain.bo.test.TestEquals2;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 测试类2个类是否相等
 */
@Slf4j
public class TestEqualsCase {

    private static final String JSON_DEAULT = "{\n" + "    \"A\": \"1\",\n" + "    \"B\": \"2\",\n"
            + "    \"C\": true,\n" + "    \"testsEqualsSonBOs\": [\n" + "        {\n"
            + "            \"SonA\": \"son_a\",\n" + "            \"SonB\": 1,\n" + "            \n" + "        },\n"
            + "        {\n" + "            \"SonA\": \"son_a2\",\n" + "            \"SonB\": 2,\n"
            + "            \"SonC\": false\n" + "        }\n" + "    ]\n" + "}";

    @Test
    public void testTestEquals() {
        log.info("testTestEquals start");
        TestEquals original = new TestEquals();
        original.setA("2");
        original.setB(3);
        original.setC(false);

        // 把json内容，转成我要测试的类，我要测试的类(TestEquals)里就只有a b c3个属性，其它数据不会转过来
        TestEquals translate = JSON.parseObject(JSON_DEAULT, TestEquals.class);

        Assert.assertEquals(original, translate);
        log.info("testTestEquals end");
    }

    @Test
    public void testTestEquals2() {
        log.info("testTestEquals2 start");
        TestEquals2 original2 = new TestEquals2();
        original2.setA("2");
        original2.setB(3);
        original2.setC(false);

        List<TestEqualsSonBO> testEqualsSonBOs = new ArrayList<>();
        TestEqualsSonBO testEqualsSonBO = new TestEqualsSonBO();
        testEqualsSonBO.setSonA("aaaaa");
        testEqualsSonBO.setSonB(2);
        testEqualsSonBO.setSonC(false);
        testEqualsSonBOs.add(testEqualsSonBO);
        original2.setTestsEqualsSonBOs(testEqualsSonBOs);
        // 到这里，测试的对象初始化好了

        // 把json内容，转成我要测试的类，我要测试的类(TestEquals2)里就只有a b c testsEqualsSonBOs 4个属性，其它数据不会转过来
        TestEquals2 translate2 = JSON.parseObject(JSON_DEAULT, TestEquals2.class);

        Assert.assertEquals(original2, translate2);
        log.info("testTestEquals2 end");
    }

    @Test
    public void testTestEquals3() {
        // TODO, 试试写一个Assert.assertEquals(original3, translate3) == ture 的用例
    }

    /**
     * 这里可以把json转换成对象，也可以把对象转成json
     */
    @Test
    public void testTestEquals4() {
        // 把json内容转成一个完全的对象，每个属性都有值
        TestEqualsFatherBO translateTotalObject = JSON.parseObject(JSON_DEAULT, TestEqualsFatherBO.class);
        log.info("translateTotalObject {}", translateTotalObject);

        String jsonStr = JSON.toJSONString(translateTotalObject);
        log.info("jsonStr is {}", jsonStr);
    }

}