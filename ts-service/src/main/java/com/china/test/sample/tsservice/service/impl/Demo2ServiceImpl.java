package com.china.test.sample.tsservice.service.impl;

import com.china.test.sample.tsdao.mongodb.test2.domain.Demo2;
import com.china.test.sample.tsdao.mongodb.test2.repository.Demo2Repository;
import com.china.test.sample.tsservice.service.Demo2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 服务类
 *
 * @author yandongjun
 */
@Service
public class Demo2ServiceImpl implements Demo2Service {
    @Autowired
    Demo2Repository demo2Repository;

    @Override
    public List<Demo2> findDemo2sByName(String name) {
        return null;
    }

    @Override
    public Demo2 findDemo2ByName(String name) {
        return null;
    }

    @Override
    public Demo2 addDemo2(Demo2 demo2) {
        return demo2Repository.insert(demo2);
    }

    @Override
    public void delDemo2(Demo2 demo2) {
        demo2Repository.delete(demo2);
    }

    @Override
    public Demo2 updateDemo2(Demo2 demo2) {
        return demo2Repository.save(demo2);
    }


}
