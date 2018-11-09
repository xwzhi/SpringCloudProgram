package com.springcloud.order.controller;

import com.springcloud.order.dto.OrderDTO;
import com.springcloud.order.message.StreamClient;
import com.springcloud.order.message.StreamOutput;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName SendMesssageController
 * @Author XuWeiZhi
 * @Description
 * @Date 2018-10-11 23:08 星期四 Worklearn
 * @VERSION 1.0.0
 **/
@RestController
@Slf4j
public class SendMesssageController {

    //@Autowired
    //private StreamClient streamClient;

    @Autowired
    private StreamClient streamOutput;

    //@GetMapping("/sendMessage")
    //public void process() {
    //    System.out.println("xxxxxxxxxx");
    //    streamClient.output().send(MessageBuilder.withPayload("sdsdasda").build());
    //}

    //@GetMapping("/sendMessageTest")
    //public void process1(){
    //        streamOutput.output().send(MessageBuilder.withPayload("xxxx").build());
    //}

    @GetMapping("/sendObject")
    public void processObject(){
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setOrderId("124651345");
        streamOutput.output().send(MessageBuilder.withPayload(orderDTO).build());

    }

}
