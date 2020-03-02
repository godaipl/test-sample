package com.china.test.sample.tsservice.service;

import java.util.List;

import com.china.test.sample.tsdao.mongodb.test.domain.Demo;

/**
 * 测试服务类
 *
 * @author yandongjun
 */
public interface DemoService {
    /**
     * 在服务层写一个通过名字找Demo的方法，返回所有名字叫这个的数据
     *
     * @param name
     * @return
     */
    List<Demo> findDemosByName(String name);

    /**
     * 在服务层写一个通过名字找Demo的方法,只返回一条数据
     *
     * @param name
     * @return
     */
    Demo findDemoByName(String name);

    /**
     * 添加Demo
     *
     * @param demo
     */
    Demo addDemo(Demo demo);

    /**
     * 删除Demo
     *
     * @param demo
     */
    void delDemo(Demo demo);

    /**
     * 更新Demo,底层的save方法如果发现有就会更新save，如果没有会进行添加操作insert
     *
     * @param demo
     * @return
     */
    Demo updateDemo(Demo demo);
}
