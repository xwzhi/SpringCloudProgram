package com.hdo.mybatis.mapper;

import com.hdo.mybatis.bean.Book;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * @ClassName BookService
 * @Author XWZ
 * @Description rabbitMq 注解版
 * @Date 2018-09-10 23:05 星期一 SpringBootProgram
 * @VERSION 1.0.0
 **/
@Service
public class BookService {

    //监听消息队列 一有消息 监听消息队列中的内容
    @RabbitListener(queues = "atguigu.news")
    public void receive(Book book){
        //把接受到的信息注入到变量中
        System.out.println("接收到了一个消息队列:"+book);
    }

    @RabbitListener(queues = "atguigu")
    public void receiveHeaders(Message message){
        System.out.println(message.getBody());
        System.out.println(message.getMessageProperties());
    }
}
