package com.china.test.sample.tsweb.service;

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
}