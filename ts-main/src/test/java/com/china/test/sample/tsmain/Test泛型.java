package com.china.test.sample.tsmain;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 测试类2个类是否相等
 */
@Slf4j
public class Test泛型 {
    /**
     * 以下形式就是典型的默认情况
     * java中所有对象的父类都是Object,所以，只要是java的对象，都可以往里面塞
     * List<Object> list = new ArrayList<>()
     * List list = new ArrayList<>()
     */
    @Test
    public void testList() {
        List arrayList = new ArrayList<>();
        arrayList.add("aaaa");
        arrayList.add(100);

        for (Object object : arrayList) {
            log.info("object is {}", object);
        }
    }

    /**
     * 这个例子就是典型的List中可以存放
     * T 及 T的子类
     * 具体例子里就是Fruit是父类，其它都是子类
     * List<T> list = new ArrayList<>()
     */
    @Test
    public void testListT() {
        Fruit fruit = new Fruit();
        Banana banana = new Banana();
        Apple apple = new Apple();
        List<Fruit> fruits = new ArrayList<>();
        fruits.add(fruit);
        fruits.add(banana);
        fruits.add(apple);

        log.info("fruits is {}", fruits);

        List<Apple> fruits2 = new ArrayList<>();
        // 就只能添加apple及apple的子类
//        fruits2.add(fruit);
//        fruits2.add(banana);
        fruits2.add(apple);
    }

    /**
     * List<?> list = new ArrayList<>()
     */
    @Test
    public void testList问号() {
        List<?> list = new ArrayList<String>();

    }

    class Fruit {
        @Override
        public String toString() {
            return "fruit";
        }
    }

    class Apple extends Fruit {
        @Override
        public String toString() {
            return "apple";
        }
    }

    class Banana extends Fruit {
        @Override
        public String toString() {
            return "Banana";
        }
    }

    class Person {
        @Override
        public String toString() {
            return "Person";
        }
    }

    class Chinese extends Person {
        @Override
        public String toString() {
            return "Chinese";
        }
    }

    class American extends Person {
        @Override
        public String toString() {
            return "American";
        }
    }

    /**
     * 这是一个泛型类
     *
     * @param <T>
     */
    static class Generic<T> {
        List<T> ts;

        /**
         * 集合中删除一个元素
         *
         * @param list
         * @param <T>
         * @return
         */
        public static <T> List<T> reduceList(List<T> list) {
            list.remove(0);
            return list;
        }

        public static <T> List<T> newArrayList() {
            return new ArrayList<>();
        }
    }

    @Test
    public void test111() {
        Date date5 = DateUtil.parseDate("2020-02-28");
        Date date = DateUtil.addMonth(date5, 4);
        log.info(date.toString());
    }
}