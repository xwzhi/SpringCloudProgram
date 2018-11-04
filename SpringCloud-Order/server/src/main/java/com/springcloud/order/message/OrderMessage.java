package com.springcloud.order.message;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @ClassName OrderMessage
 * @Author XuWeiZhi
 * @Description 接收方
 * @Date 2018-10-11 21:26 星期四 Worklearn
 * @VERSION 1.0.0
 **/
@Slf4j
@Component
public class OrderMessage {


    //1.@RabbitListener(queues = "myQueue")
    //2.自动创建队列@RabbitListener(queuesToDeclare = @Queue("myQueue"))
    //3.自动创建，Exchange和Queue
  /*  @RabbitListener(bindings =@QueueBinding(
            value=@Queue("myQueue"),
            exchange = @Exchange("myExchange")
    ))
    public void process(String message){
        log.info("MyReceiver:{}",message);
    }*/

    /**
     * @Author XuWeiZhi
     * @Description 电脑供应商
     * @Date 2018/10/11 22:13
     **/
    @RabbitListener(bindings = @QueueBinding(
            exchange = @Exchange("MyOrder"),
            key = "computer",
            value = @Queue("computerOrder")
    ))
    public void processComputer(String message) {
        log.info("ComputerReceive={}", "now :" + message);
    }

    /**
     * @Author XuWeiZhi
     * @Description 水供应商
     * @Date 2018/10/11 22:13
     **/
    @RabbitListener(bindings = @QueueBinding(
            exchange = @Exchange("MyOrder"),
            key = "water",
            value = @Queue("waterOrder")
    ))
    public void processWater(String message) {
        log.info("WaterReceive={}", "now :" + message);
    }

}
