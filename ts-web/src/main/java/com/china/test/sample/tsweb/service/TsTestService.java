package com.china.test.sample.tsweb.service;

import com.china.test.sample.tsdao.tsdb.domain.TsTest;
import com.china.test.sample.tsweb.views.TsTestVO;

import java.util.List;

/**
 * 业务接口
 */
public interface TsTestService {

    /**
     * 模拟生成一个集合
     *
     * @return
     */
    List<TsTestVO> getTsTestVOListForShowTestInfo();

    /**
     * 获取一个TsTestVO集合
     *
     * @return
     */
    List<TsTestVO> getTsTestVOListForShowTestInfo3();

    /**
     * 获取数据库中的原始数据
     *
     * @return
     */
    List<TsTest> getTsTestListForCrudTemplate();

    /**
     * 添加对象至数据库中
     * 
     * @param tsTest
     */
    Integer addTsTest(TsTest tsTest);

    /**
     * 修改数据库中的对象
     * 
     * @param tsTest
     */
    Integer editTsTest(TsTest tsTest);

    /**
     * 添加对象至数据库中
     * 
     * @param tsTest
     */
    Integer delTsTest(Integer id);

    /**
     * 根据id获取对象
     * 
     * @param id
     * @return
     */
    TsTest getTsTest(Integer id);
}