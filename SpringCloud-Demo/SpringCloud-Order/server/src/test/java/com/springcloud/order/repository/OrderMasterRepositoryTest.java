package com.springcloud.order.repository;

import com.springcloud.order.OrderApplicationTests;
import com.springcloud.order.dataobject.OrderMaster;
import com.springcloud.order.enums.OrderStatusEnum;
import com.springcloud.order.enums.PayStatusEnum;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by 廖师兄
 * 2017-12-10 16:13
 */
@Component
public class OrderMasterRepositoryTest extends OrderApplicationTests {

    @Autowired
    private OrderMasterRepository orderMasterRepository;

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Test
    public void testSave() {
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("1234567");
        orderMaster.setBuyerName("师兄");
        orderMaster.setBuyerPhone("1886131241241");
        orderMaster.setBuyerAddress("慕课网总部");
        orderMaster.setBuyerOpenid("1101110");
        orderMaster.setOrderAmount(new BigDecimal(2.5));
        orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
        orderMaster.setPayStatus(PayStatusEnum.WAIT.getCode());

        OrderMaster result = orderMasterRepository.save(orderMaster);
        Assert.assertTrue(result != null);
    }


   /* @Test
    public void textAmqpAdmin2(){
        //创建交换器
        amqpAdmin.declareExchange(new TopicExchange("MyTest.txt"));
        //创建队列 是否可持久化
        amqpAdmin.declareQueue(new Queue("myQueue",true));
        //创建绑定规则 绑定的对象 对象类型 绑定的交换器 路由件 mapcanshu
        amqpAdmin.declareBinding(new Binding("myQueue", Binding.DestinationType.QUEUE,"\"MyTest.txt","",null));
    }*/

   /* //@Test
    //public void postMessage(){
    //    amqpTemplate.convertAndSend("myQueue","发送时间"+new Date());
    //}
    //
    //@Test
    //public void computerMessage(){
    //    amqpTemplate.convertAndSend("MyOrder","computer","电脑订单购买时间:"+new Date());
    //}
    //
    //@Test
    //public void waterMessage(){
    //    amqpTemplate.convertAndSend("MyOrder","water","水订单购买时间:"+new Date());
    //}*/
}