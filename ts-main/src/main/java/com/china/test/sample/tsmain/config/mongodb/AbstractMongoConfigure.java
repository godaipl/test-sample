package com.china.test.sample.tsmain.config.mongodb;

import com.mongodb.MongoClient;
import lombok.Data;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

/**
 * @author yandongjun
 */
@Data
public abstract class AbstractMongoConfigure {
    /**
     * 后面如果要加用户名密码，我们需要添加用户名和密码，然后修改下面的mongoDbFactory方法
     */
    private String host, database;
    private int port;

    /**
     * @return MongoDbFactory mongoDb的工厂类，用于生成mongo的模板类
     * @throws Exception
     */
    public MongoDbFactory mongoDbFactory() {
        return new SimpleMongoDbFactory(new MongoClient(host, port), database);
    }

    /**
     * Factory method to create the MongoTemplate
     *
     * @return MongoTemplate 返回mongo操作数据库的模板类
     * @throws Exception
     */
    abstract public MongoTemplate getMongoTemplate() throws Exception;
}
