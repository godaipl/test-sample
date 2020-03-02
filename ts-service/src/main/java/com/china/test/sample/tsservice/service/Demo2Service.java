package com.china.test.sample.tsservice.service;

import com.china.test.sample.tsdao.mongodb.test2.domain.Demo2;

import java.util.List;

/**
 * 测试服务类
 *
 * @author yandongjun
 */
public interface Demo2Service {
    /**
     * 在服务层写一个通过名字找Demo2的方法，返回所有名字叫这个的数据
     *
     * @param name
     * @return
     */
    List<Demo2> findDemo2sByName(String name);

    /**
     * 在服务层写一个通过名字找Demo的方法,只返回一条数据
     *
     * @param name
     * @return
     */
    Demo2 findDemo2ByName(String name);

    /**
     * 添加Demo
     *
     * @param demo2
     */
    Demo2 addDemo2(Demo2 demo2);

    /**
     * 删除Demo
     *
     * @param demo2
     */
    void delDemo2(Demo2 demo2);

    /**
     * 更新Demo,底层的save方法如果发现有就会更新save，如果没有会进行添加操作insert
     *
     * @param demo2
     * @return
     */
    Demo2 updateDemo2(Demo2 demo2);
}
