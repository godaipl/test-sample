package com.china.test.sample.tsmain.config.mongodb;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * @author yandongjun
 */
@Configuration
@EnableMongoRepositories(basePackages = "com.china.test.sample.tsdao.mongodb.test2.repository",
        mongoTemplateRef = Test2MongoConfig.MONGO_TEMPLATE)
@ConfigurationProperties(prefix = "spring.mongodb.test2")
public class Test2MongoConfig extends AbstractMongoConfigure {
    protected static final String MONGO_TEMPLATE = "test2MongoTemplate";

    @Override
    @Bean(name = MONGO_TEMPLATE)
    public MongoTemplate getMongoTemplate() throws Exception {
        return new MongoTemplate(mongoDbFactory());
    }
}
