package com.springcloud.order.message;

import com.springcloud.order.dto.OrderDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

/**
 * @ClassName StreamMessageTest
 * @Author XuWeiZhi
 * @Description
 * @Date 2018-10-14 22:04 星期日 Worklearn
 * @VERSION 1.0.0
 **/
@EnableBinding(StreamClient.class)//启动绑定
@Component
@Slf4j
public class StreamReceiver {

    //监听该通道的信息：在配置文件配置了监听某交换机的某个队列
    //并且在文件中配置了json格式的数据接收方式
    //@StreamListener(StreamInput.INPUT)
    //public void inputTest(String message) {
    //    log.info("StreamMessageTest:{}", message);
    //}

    //接收OrderDTO对象
    @StreamListener(StreamClient.INPUT)
    @SendTo(StreamClient.INPUT2)//接收到消息后向INPUT2发送消息
    public String inputTest(OrderDTO orderDTO) {
        log.info("StreamMessageTest:{}", orderDTO);
        //可直接返回给消息队列
        return "我已经接收到消息了";
    }

    @StreamListener(StreamClient.INPUT2)
    public void input2Test(String message) {
        log.info("StreamMessageTest2:{}", message);
    }
}
