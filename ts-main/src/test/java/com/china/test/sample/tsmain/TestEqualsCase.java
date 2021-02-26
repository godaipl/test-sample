package com.china.test.sample.tsmain;

import com.alibaba.fastjson.JSON;
import com.china.test.sample.tsmain.bo.TestEqualsFatherBO;
import com.china.test.sample.tsmain.bo.TestEqualsSonBO;
import com.china.test.sample.tsmain.bo.test.TestEquals;
import com.china.test.sample.tsmain.bo.test.TestEquals2;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;

/**
 * 测试类2个类是否相等
 */
@Slf4j
public class TestEqualsCase {

    private static final String JSON_DEFAULT = "{\n" + "    \"A\": \"1\",\n" + "    \"B\": \"2\",\n"
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
        TestEquals translate = JSON.parseObject(JSON_DEFAULT, TestEquals.class);

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
        TestEquals2 translate2 = JSON.parseObject(JSON_DEFAULT, TestEquals2.class);

        Assert.assertEquals(original2, translate2);
        log.info("testTestEquals2 end");
    }

    @Test
    public void testTestEquals3() {
        // 试试写一个Assert.assertEquals(original3, translate3) == true 的用例
    }

    /**
     * 这里可以把json转换成对象，也可以把对象转成json
     */
    @Test
    public void testTestEquals4() {
        // 把json内容转成一个完全的对象，每个属性都有值
        TestEqualsFatherBO translateTotalObject = JSON.parseObject(JSON_DEFAULT, TestEqualsFatherBO.class);
        log.info("translateTotalObject {}", translateTotalObject);

        String jsonStr = JSON.toJSONString(translateTotalObject);
        log.info("jsonStr is {}", jsonStr);
    }

    @Test
    public void testSomeThing() {
//                List<Student> list = List.of(
//                        new Student("Bob", 78),
//                        new Student("Alice", 85),
//                        new Student("Brush", 66),
//                        new Student("Newton", 99));
//                Students holder = new Students(list);
//                System.out.println(holder.getScore("Bob") == 78 ? "测试成功!" : "测试失败!");
//                System.out.println(holder.getScore("Alice") == 85 ? "测试成功!" : "测试失败!");
//                System.out.println(holder.getScore("Tom") == -1 ? "测试成功!" : "测试失败!");
    }

    class Students {
        List<Student> list;
        Map<String, Integer> cache;

        Students(List<Student> list) {
            this.list = list;
            cache = new HashMap<>();
            for (Student student : list) {
                cache.put(student.name, student.score);
            }
        }

        /**
         * 根据name查找score，找到返回score，未找到返回-1
         */
        int getScore(String name) {
            // 先在Map中查找:
            Integer score = this.cache.get(name);
            if (score == null) {
                // TODO:
            }
            return score == null ? -1 : score.intValue();
        }

        Integer findInList(String name) {
            for (Student ss : this.list) {
                if (ss.name.equals(name)) {
                    return ss.score;
                }
            }
            return null;
        }
    }

    class Student {
        String name;
        int score;

        Student(String name, int score) {
            this.name = name;
            this.score = score;
        }
    }

    @Test
    public void testMs() {
        Set a = new HashSet();
        a.add(null);
        a.add(null);
        a.add(null);
        a.add(null);
        a.add(null);
        System.out.println(a);

        Map b = new HashMap();
        b.put(null, "a");
        b.put(null, "a");
        b.put(null, "a");
        b.put(null, "a");
        System.out.println(b);
    }

}