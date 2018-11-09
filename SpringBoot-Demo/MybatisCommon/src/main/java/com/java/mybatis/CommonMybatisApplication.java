package com.java.mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.java.mybatis.mapper")
public class CommonMybatisApplication {

    public static void main(String[] args) {
        SpringApplication.run(CommonMybatisApplication.class, args);
    }


}
