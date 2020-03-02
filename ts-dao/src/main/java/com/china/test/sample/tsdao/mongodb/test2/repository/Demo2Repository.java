package com.china.test.sample.tsdao.mongodb.test2.repository;

import com.china.test.sample.tsdao.mongodb.test2.domain.Demo2;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Demo2类数据库操作封装
 *
 * @author yandongjun
 */
public interface Demo2Repository extends MongoRepository<Demo2, String> {
}
