package com.china.test.sample.tsservice.service.impl;

import java.util.List;

import com.china.test.sample.tsdao.mongodb.test.repository.DemoRepository;
import com.china.test.sample.tsdao.mongodb.test.domain.Demo;
import com.china.test.sample.tsservice.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 服务类
 *
 * @author yandongjun
 */
@Service
public class DemoServiceImpl implements DemoService {
    @Autowired
    DemoRepository demoRepository;

    @Override
    public List<Demo> findDemosByName(String name) {
        return demoRepository.findByName(name);
    }

    @Override
    public Demo findDemoByName(String name) {
        return null;
    }

    

    @Override
    public Demo addDemo(Demo demo) {
        return demoRepository.insert(demo);
    }

    @Override
    public void delDemo(Demo demo) {
        demoRepository.delete(demo);
    }

    @Override
    public Demo updateDemo(Demo demo) {
        return demoRepository.save(demo);
    }

   
}
