package com.china.test.sample.tsmain.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * @author yandongjun
 */
@Configuration
@MapperScan(basePackages = "com.china.test.sample.tsdao.ts2db.mapper", sqlSessionTemplateRef = "ts2dbSqlSessionTemplate")
public class Ts2DbConfiguration {
    /**
     * 创建数据源
     *
     * @return DataSource
     */
    @Bean(name = "ts2dbDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.ts2db")
    public DataSource ts2dbDataSource() {
        return DataSourceBuilder.create().build();
    }

    /**
     * 创建工厂
     *
     * @param dataSource
     * @return SqlSessionFactory
     * @throws Exception
     */
    @Bean(name = "ts2dbSqlSessionFactory")
    public SqlSessionFactory ts2dbSqlSessionFactory(@Qualifier("ts2dbDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:sqlmap/ts2db/*.xml"));
        return bean.getObject();
    }

    /**
     * 创建事务
     *
     * @param dataSource
     * @return DataSourceTransactionManager
     */
    @Bean(name = "ts2dbTransactionManager")
    public DataSourceTransactionManager ts2dbDataSourceTransactionManager(@Qualifier("ts2dbDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    /**
     * 创建模板
     *
     * @param sqlSessionFactory
     * @return SqlSessionTemplate
     */
    @Bean(name = "ts2dbSqlSessionTemplate")
    public SqlSessionTemplate ts2dbSqlSessionTemplate(@Qualifier("ts2dbSqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
