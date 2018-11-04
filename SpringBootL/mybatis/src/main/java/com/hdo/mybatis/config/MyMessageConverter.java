package com.hdo.mybatis.config;

import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName MyMessageConverter
 * @Author XWZ
 * @Description
 * @Date 2018-09-10 22:47 星期一 SpringBootProgram
 * @VERSION 1.0.0
 **/
@Configuration
public class MyMessageConverter {

    //自定义rabbitMq队列组件
    @Bean
    public MessageConverter messageConverter(){
        return new Jackson2JsonMessageConverter();
    }
}
