package com.ewell.esb.common.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.ewell.esb.common.config.properties.DynamicDataSource;
import com.ewell.esb.common.util.DBSourceConstant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.annotation.Order;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.HashMap;
@Slf4j
@EnableTransactionManagement(proxyTargetClass = true,order = 2)
@Configuration
public class DataSourceConfig {
    @Bean(name = "masterDataSource")
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.druid")
    public DruidDataSource masterDataSource(){
        return new DruidDataSource();
    }
    @Bean(name = "clusterDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.cluster-druid")
    public DruidDataSource clusterDataSource(){
        return new DruidDataSource();
    }
    /**
     * 单数据源连接池配置
     */
    @Bean
    @ConditionalOnProperty(name = "muti-datasource-open", havingValue = "false")
    public DruidDataSource singleDatasource(@Qualifier("masterDataSource") DruidDataSource masterDataSource) {
        return masterDataSource;
    }
    /**
     * 多数据源连接池配置
     */
    @Bean
    @ConditionalOnProperty(name = "muti-datasource-open", havingValue = "true")
    public DynamicDataSource mutiDataSource(@Qualifier("masterDataSource") DruidDataSource masterDataSource,
         @Qualifier("clusterDataSource") DruidDataSource clusterDataSource) {
        try {
            masterDataSource.init();
            clusterDataSource.init();
        } catch (SQLException sql) {
            log.error("数据源初始化异常,异常信息是"+sql.getMessage());
        }
        DynamicDataSource dynamicDataSource = new DynamicDataSource();
        HashMap<Object, Object> hashMap = new HashMap<>();
        hashMap.put(DBSourceConstant.DATA_SOURCE_MASTER, masterDataSource);
        hashMap.put(DBSourceConstant.DATA_SOURCE_CLUSTER, clusterDataSource);
        dynamicDataSource.setTargetDataSources(hashMap);
        dynamicDataSource.setDefaultTargetDataSource(masterDataSource);
        return dynamicDataSource;
    }

    @Bean
    @ConditionalOnProperty(name = "muti-datasource-open", havingValue = "false")
    public DataSourceTransactionManager singleTransactionManager( @Qualifier("singleDatasource") DataSource dataSource)
    {
        DataSourceTransactionManager singledataSourceTransactionManager = new DataSourceTransactionManager();
        singledataSourceTransactionManager.setDataSource(dataSource);
        return singledataSourceTransactionManager;
    }

    @Bean
    @ConditionalOnProperty(name = "muti-datasource-open", havingValue = "true")
    public DataSourceTransactionManager clusterTransactionManager( @Qualifier("mutiDataSource") DataSource dataSource)
    {
        DataSourceTransactionManager mutiDataSourceTransactionManager = new DataSourceTransactionManager();
        mutiDataSourceTransactionManager.setDataSource(dataSource);
        return mutiDataSourceTransactionManager;
    }
}
