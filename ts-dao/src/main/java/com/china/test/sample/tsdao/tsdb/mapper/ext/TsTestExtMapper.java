package com.china.test.sample.tsdao.tsdb.mapper.ext;

import com.china.test.sample.tsdao.tsdb.domain.TsTest;
import com.china.test.sample.tsdao.tsdb.domain.ext.TsTestExt;

/**
 * 手工创建的mapper类
 *
 * @author yandongjun
 */
public interface TsTestExtMapper {
    /**
     * 数一数id大于传入参数的数据有多少条
     *
     * @param id
     * @return
     */
    int countSomethingGreaterThenId(int id);

    /**
     * 通过id获取对象
     *
     * @param id
     * @return
     */
    TsTest selectById(int id);


    /**
     * 通过id获取自定义的数据
     *
     * @param id
     * @return
     */
    TsTestExt selectExtById(int id);
}