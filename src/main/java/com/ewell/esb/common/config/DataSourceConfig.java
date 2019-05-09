package com.ewell.esb.common.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.ewell.esb.common.util.SpringContextHolder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class DataSourceConfig {
    @Bean(name = "dataSource")
    @Qualifier(value = "dataSource")
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.druid")
    public DataSource masterDataSource(){
        return new DruidDataSource();
    }



    /*
    @Bean(name = "clusterDataSource")
    @Qualifier(value = "clusterDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.cluster-druid")
    public DataSource clusterDataSource(){
        return new DruidDataSource();
    }
        @Bean(name = "clusterTransactionManager")
    public DataSourceTransactionManager clusterTransactionManager(@Qualifier("clusterDataSource") DataSource dataSource)
    {
        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
        dataSourceTransactionManager.setDataSource(dataSource);
        return dataSourceTransactionManager;
    }
    */
    @Bean(name = "TransactionManager")
    @Primary
    public DataSourceTransactionManager masterTransactionManager(@Qualifier("dataSource") DataSource dataSource)
    {
        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
        dataSourceTransactionManager.setDataSource(dataSource);
        return dataSourceTransactionManager;
    }



}
