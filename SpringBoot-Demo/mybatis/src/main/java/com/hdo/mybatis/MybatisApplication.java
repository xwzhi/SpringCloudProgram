package com.hdo.mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 *@Author XWZ
 *@Descriptio
 *@Date 2018/9/9 20:29
 * 原理:引入CacheManager==Cache 缓存组件在缓存中获取数据
 *  1. 引入redis的start，容器中保存的是RedisCacheManager
 *  2. RedisCacheManager帮我们创建RedisCache来作为缓存组件;RedisCache通过操作Redis来缓存数据
 *  3. 默认保存数据k-v都是Object;利用序列化保存，如何保存Redis
 *      1.引入redis的starter cacheManager
 *      2.默认创建的RedisCacheManager操作redis的时候,使用的是
 *      3.RedisTemplate<Object,Object>默认的是JDK的序列化机制
 *  4.自定义CacheManager
 * rabbitmq 自动配置
 *  1.RabbitAutoConfiguration
 *  2.有自动配置了工厂ConnectionFactory
 *  3.RabbitProperties 封装了rabbitMq的配置
 *  4.RabbitTemplate 给RabbitMQ发送和接受 消息
 *  5.AmqpAdmin:RabbitMQ系统管理功能组件
 *    AmqpAdmin：创建和删除queue,exchangeBinding
 *  6.@EnableRabbit+@RabbitListener监听消息队列
 *  索引
 *    Spring boot 默认支持两种技术来和Es交互
 *      1.Jest 默认不生效
 *        需要导入jest的工具包
 *      2.SpringData ElasticSearch[版本有可能不适配]
 *         版本适配说明，https://github.com/spring/projects/spring-data-elasticsearch
 *          a.升级SpringBoot版本
 *          b.安装对应版本的es
 *        1. Client 节点信息clusterNodes,slusterName
 *        2. ElasticsearchTemplate
 **/
@MapperScan(basePackages = "com.product.mybatis.mapper")
@SpringBootApplication
@EnableAsync      //开启异步处理
@EnableScheduling //开启定时任务
@EnableCaching    //开启缓存注解
@EnableRabbit     //开启基于注解的RabbitMQ模式
public class MybatisApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatisApplication.class, args);
    }
}
