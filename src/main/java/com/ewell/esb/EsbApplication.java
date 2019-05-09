package com.ewell.esb;

import com.ewell.esb.common.util.SpringContextHolder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.util.StringValueResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
@EnableTransactionManagement(proxyTargetClass = true)
@PropertySource(value = "file:config/conf.properties",ignoreResourceNotFound = true)
public class EsbApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(EsbApplication.class, args);
    }

    @Bean
    public SpringContextHolder springContextHolder() {
        return new SpringContextHolder();
    }

}
