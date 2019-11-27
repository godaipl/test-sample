package com.china.test.sample.tsweb.service.impl;

import com.china.test.sample.tsdao.tsdb.domain.TsTest;
import com.china.test.sample.tsdao.tsdb.mapper.TsTestMapper;
import com.china.test.sample.tsweb.service.TsTestService;
import com.china.test.sample.tsweb.views.TsTestVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 业务接口实现
 *
 * @author yandongjun
 * @date 2019-11-27 16:20
 */
@Service
@Slf4j
public class TsTestServiceImpl implements TsTestService {
    @Autowired
    TsTestMapper tsTestMapper;

    @Override
    public List<TsTestVO> getTsTestVOListForShowTestInfo() {
        List<TsTestVO> tsTestVOs = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            TsTestVO vo = new TsTestVO();
            vo.setName(String.valueOf(i));
            vo.setExtraInfo("extraInfo is " + i);
            tsTestVOs.add(vo);
        }
        return tsTestVOs;
    }

    @Override
    public List<TsTestVO> getTsTestVOListForShowTestInfo3() {
        log.info("getTsTestVOList start");
        // 查询结果
        List<TsTest> tsTestList = tsTestMapper.selectByExample(null);

        // 转化为前端类
        List<TsTestVO> tsTestVOs = translateTsTestsToTsTestVOs(tsTestList);
        log.info("getTsTestVOList end");
        return tsTestVOs;
    }

    /**
     * 将TsTest集合转换成TsTestVO集合
     *
     * @param tsTests
     * @return
     */
    private List<TsTestVO> translateTsTestsToTsTestVOs(List<TsTest> tsTests) {
        List<TsTestVO> tsTestVOs = null;
        if (!CollectionUtils.isEmpty(tsTests)) {
            tsTestVOs = new ArrayList<>();
            for (TsTest tsTest : tsTests) {
                tsTestVOs.add(translateTsTestToTsTestVO(tsTest));
            }
        }

        return tsTestVOs;
    }

    /**
     * 将TsTest转换成TsTestVO
     *
     * @param tsTest
     * @return
     */
    private TsTestVO translateTsTestToTsTestVO(TsTest tsTest) {
        TsTestVO tsTestVO = new TsTestVO();
        tsTestVO.setName(tsTest.getUserName());
        tsTestVO.setExtraInfo("extraInfo" + tsTest.getAge());

        return tsTestVO;
    }

}