package com.login.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/*
配置数据源
 */
@Configuration
public class DataSourceConfig {

    @Bean(name = "dataUser")
    @Qualifier("dataUser")
    @ConfigurationProperties(prefix="spring.datasource.user")
    public DataSource dataUser() {
        return DataSourceBuilder.create().build();
    }

}
