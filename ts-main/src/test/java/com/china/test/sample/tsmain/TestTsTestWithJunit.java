package com.china.test.sample.tsmain;

import java.util.List;
import java.util.stream.Collectors;

import com.china.test.sample.tsdao.ts2db.mapper.TsTest2Mapper;
import com.china.test.sample.tsdao.tsdb.domain.TsTest;
import com.china.test.sample.tsdao.tsdb.domain.TsTestCriteria;
import com.china.test.sample.tsdao.tsdb.mapper.TsTestMapper;

import com.china.test.sample.tsdao.tsdb.mapper.ext.TsTestExtMapper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import lombok.extern.slf4j.Slf4j;

/**
 * @author yandongjun
 */
@Slf4j
public class TestTsTestWithJunit extends BaseJunitTest {
    /**
     * 这个是test数据库的表
     */
    @Autowired
    TsTestMapper tsTestMapper;

    /**
     * 这个是test2数据库的表
     */
    @Autowired
    TsTest2Mapper tsTest2Mapper;

    /**
     * 这是一个自定义的mapper
     */
    @Autowired
    TsTestExtMapper tsTestExtMapper;

    /**
     * 测试获取表中的所有数据
     */
    @Test
    public void testGetTsTestList() throws Exception {
        // 首先创建查询条件
        TsTestCriteria tsTestCriteria = new TsTestCriteria();
        tsTestCriteria.createCriteria().andIdEqualTo(1);
        List<TsTest> tsTestList = tsTestMapper.selectByExample(tsTestCriteria);
        List<Integer> tsTestIds = tsTestList.stream().map(TsTest::getId).collect(Collectors.toList());
        log.info("testGetTsTestList tsTestList is {}", tsTestList);
        log.info("testGetTsTestList tsTestIds is {}", tsTestIds);

        TsTest tsTest = tsTestMapper.selectByPrimaryKey(1);
        log.info("testGetTsTestList tsTest is {}", tsTest);
    }

    /**
     * 测试自定义mapper
     */
    @Test
    public void setTsTestExtMapper() {
        tsTestExtMapper.selectById(1);
        tsTestExtMapper.selectExtById(1);
        tsTestExtMapper.selectTsTestById(1);
    }
}
