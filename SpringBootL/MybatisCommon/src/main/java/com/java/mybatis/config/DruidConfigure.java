package com.java.mybatis.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @ClassName DruidConfigure
 * @Author XuWeiZhi
 * @Description
 * @Date 2018-11-07 11:38 星期三 MySpringCloud
 * @VERSION 1.0.0
 **/
@Configuration
public class DruidConfigure {


    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource druid(){
        return new DruidDataSource();
    }

}
