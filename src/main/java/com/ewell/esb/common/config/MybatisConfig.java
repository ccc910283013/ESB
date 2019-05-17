package com.ewell.esb.common.config;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.io.IOException;
@Slf4j
@Configuration
@MapperScan(basePackages = "com.ewell.esb.dao")
public class MybatisConfig {
    @Bean
    @ConditionalOnProperty(name = "muti-datasource-open", havingValue = "false")
    @ConfigurationProperties(prefix = "mybatis")
    public SqlSessionFactoryBean sqlSessionFactorMaster(@Qualifier("singleDatasource")DataSource singleDatasource) {
        SqlSessionFactoryBean singlesfb = new SqlSessionFactoryBean();
        try {
            PathMatchingResourcePatternResolver singleRes = new PathMatchingResourcePatternResolver();
            singlesfb.setDataSource(singleDatasource);
            singlesfb.setMapperLocations(singleRes.getResources("classpath:mapper/*.xml"));
            singlesfb.setTypeAliasesPackage("com.ewell.esb.bean");
        }catch (IOException e){
            log.error(e.getMessage());
        }

        return singlesfb;
    }

    @Bean
    @ConditionalOnProperty(name = "muti-datasource-open", havingValue = "true")
    @ConfigurationProperties(prefix = "mybatis")
    public SqlSessionFactoryBean sqlSessionFactorMutil(@Qualifier("mutiDataSource")DataSource mutiDataSource) {
        SqlSessionFactoryBean mutiSfb = new SqlSessionFactoryBean();
        try {
            PathMatchingResourcePatternResolver mutiRes = new PathMatchingResourcePatternResolver();
            mutiSfb.setDataSource(mutiDataSource);
            mutiSfb.setMapperLocations(mutiRes.getResources("classpath:mapper/*.xml"));
            mutiSfb.setTypeAliasesPackage("com.ewell.esb.bean");
        }catch (IOException e){
            log.error(e.getMessage());
        }
        return mutiSfb;
    }
}
