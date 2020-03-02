package com.china.test.sample.tsmain.config.mongodb;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * @author yandongjun
 */
@Configuration
@EnableMongoRepositories(basePackages = "com.china.test.sample.tsdao.mongodb.test.repository",
        mongoTemplateRef = TestMongoConfig.MONGO_TEMPLATE)
@ConfigurationProperties(prefix = "spring.mongodb.test")
public class TestMongoConfig extends AbstractMongoConfigure {
    protected static final String MONGO_TEMPLATE = "testMongoTemplate";

    /**
     * 只能有一个Primary，切记
     *
     * @return
     * @throws Exception
     */
    @Primary
    @Override
    @Bean(name = MONGO_TEMPLATE)
    public MongoTemplate getMongoTemplate() throws Exception {
        return new MongoTemplate(mongoDbFactory());
    }
}
