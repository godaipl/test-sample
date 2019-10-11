package com.china.test.sample.tsmain;

import com.china.test.sample.tsdao.tsdb.domain.TsTest;
import com.china.test.sample.tsdao.tsdb.domain.TsTestCriteria;
import com.china.test.sample.tsdao.tsdb.mapper.TsTestMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author yandongjun
 */
@Slf4j
public class TestTsTest extends BaseTest {
    @Autowired
    TsTestMapper tsTestMapper;

    @Test
    public void testGetTsTestList() {
        // 首先创建查询条件
        TsTestCriteria tsTestCriteria = new TsTestCriteria();
        tsTestCriteria.createCriteria().andIdEqualTo(1);
        List<TsTest> tsTestList = tsTestMapper.selectByExample(tsTestCriteria);
        log.info("tsTestList is {}", tsTestList);
    }
}
