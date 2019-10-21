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
@MapperScan(basePackages = "com.china.test.sample.tsdao.tsdb.mapper", sqlSessionTemplateRef = "tsdbSqlSessionTemplate")
public class TsDbConfiguration {

    /**
     * 创建数据源
     *
     * @return DataSource
     */
    @Bean(name = "tsdbDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.tsdb")
    public DataSource tsdbDataSource() {
        return DataSourceBuilder.create().build();
    }

    /**
     * 创建工厂
     *
     * @param dataSource
     * @return SqlSessionFactory
     * @throws Exception
     */
    @Bean(name = "tsdbSqlSessionFactory")
    public SqlSessionFactory tsdbSqlSessionFactory(@Qualifier("tsdbDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:sqlmap/tsdb/*.xml"));
        return bean.getObject();
    }

    /**
     * 创建事务
     *
     * @param dataSource
     * @return DataSourceTransactionManager
     */
    @Bean(name = "tsdbTransactionManager")
    public DataSourceTransactionManager tsdbDataSourceTransactionManager(@Qualifier("tsdbDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    /**
     * 创建模板
     *
     * @param sqlSessionFactory
     * @return SqlSessionTemplate
     */
    @Bean(name = "tsdbSqlSessionTemplate")
    public SqlSessionTemplate tsdbSqlSessionTemplate(@Qualifier("tsdbSqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
