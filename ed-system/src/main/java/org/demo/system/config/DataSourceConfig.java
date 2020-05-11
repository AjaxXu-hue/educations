package org.demo.system.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/*
配置数据源
 */
@Configuration
public class DataSourceConfig {

    @Bean(name = "dataSystem")
    @Qualifier("dataSystem")
    @Primary
    @ConfigurationProperties(prefix="spring.datasource.system")
    public DataSource dataSystem() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "dataUser")
    @Qualifier("dataUser")
    @ConfigurationProperties(prefix="spring.datasource.user")
    public DataSource dataUser() {
        return DataSourceBuilder.create().build();
    }

}
