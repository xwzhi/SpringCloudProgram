package com.springcloud.order.message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


/**
 * @ClassName Producer
 * @Author XuWeiZhi
 * @Description
 * @Date 2018-10-14 22:28 星期日 Worklearn
 * @VERSION 1.0.0
 **/
@Component
@EnableBinding({StreamOutput.class})
public class Producer {

    @Autowired
    private StreamOutput streamOutput;

    //@Scheduled(cron = "0-30 *  * * * ?")
    //public void print(){
    //    System.out.println("xxxxxxxx");
    //    streamOutput.output().send(MessageBuilder.withPayload("aaaaa").build());
    //}
}
