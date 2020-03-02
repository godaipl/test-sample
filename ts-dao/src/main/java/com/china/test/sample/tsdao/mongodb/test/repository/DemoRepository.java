package com.china.test.sample.tsdao.mongodb.test.repository;

import java.util.List;

import com.china.test.sample.tsdao.mongodb.test.domain.Demo;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Demo类数据库操作封装
 *
 * @author yandongjun
 */
public interface DemoRepository extends MongoRepository<Demo, String> {
    /**
     * 通过名称找数据
     *
     * @param name
     * @return
     */
    List<Demo> findByName(String name);
}
