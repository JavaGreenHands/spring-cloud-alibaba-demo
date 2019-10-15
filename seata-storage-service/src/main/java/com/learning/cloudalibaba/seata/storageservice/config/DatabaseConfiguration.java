package com.learning.cloudalibaba.seata.storageservice.config;

import com.alibaba.druid.pool.DruidDataSource;
import io.seata.rm.datasource.DataSourceProxy;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.SQLException;

/**
 * @author baijie
 * @date 2019-10-15
 */
@Configuration
public class DatabaseConfiguration {

    private final ApplicationContext applicationContext;

    public DatabaseConfiguration(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Bean(initMethod = "init", destroyMethod = "close")
    public DruidDataSource storageDataSource() throws SQLException {

        Environment environment = applicationContext.getEnvironment();

        String ip = environment.getProperty("mysql.server.ip");
        String port = environment.getProperty("mysql.server.port");
        String dbName = environment.getProperty("mysql.db.name");

        String userName = environment.getProperty("mysql.user.name");
        String password = environment.getProperty("mysql.user.password");

        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUrl(
                "jdbc:mysql://" + ip + ":" + port + "/" + dbName + "?serverTimezone=UTC");
        druidDataSource.setUsername(userName);
        druidDataSource.setPassword(password);
        druidDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        druidDataSource.setInitialSize(0);
        druidDataSource.setMaxActive(180);
        druidDataSource.setMaxWait(60000);
        druidDataSource.setMinIdle(0);
        druidDataSource.setValidationQuery("Select 'x' from DUAL");
        druidDataSource.setTestOnBorrow(false);
        druidDataSource.setTestOnReturn(false);
        druidDataSource.setTestWhileIdle(true);
        druidDataSource.setTimeBetweenEvictionRunsMillis(60000);
        druidDataSource.setMinEvictableIdleTimeMillis(25200000);
        druidDataSource.setRemoveAbandoned(true);
        druidDataSource.setRemoveAbandonedTimeout(1800);
        druidDataSource.setLogAbandoned(true);
        druidDataSource.setFilters("mergeStat");
        return druidDataSource;
    }

    @Bean
    public DataSourceProxy dataSourceProxy(DruidDataSource druidDataSource) {
        return new DataSourceProxy(druidDataSource);
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSourceProxy dataSourceProxy) {

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSourceProxy);

        jdbcTemplate.update("delete from storage_tbl where commodity_code = 'C00321'");
        jdbcTemplate.update(
                "insert into storage_tbl(commodity_code, count) values ('C00321', 100)");

        return jdbcTemplate;

    }

}
