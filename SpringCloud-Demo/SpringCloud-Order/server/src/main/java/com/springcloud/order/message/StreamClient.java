package com.springcloud.order.message;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;
import org.springframework.stereotype.Component;

/**
 * @ClassName StreamInput
 * @Author XuWeiZhi
 * @Description
 * @Date 2018-10-14 21:59 星期日 Worklearn
 * @VERSION 1.0.0
 **/
@Component
public interface StreamClient {

    String INPUT="input"; //通道名
    String INPUT2="input2"; //通道名
    String OUTPUT="output";
    String OUTPUT2="output2";

    @Output(OUTPUT)
    MessageChannel output();

    @Output(OUTPUT2)
    MessageChannel output2();

    @Input(INPUT)//绑定通道
    SubscribableChannel input();

    @Input(INPUT2)//绑定通道
    SubscribableChannel input2();

}
