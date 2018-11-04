package com.hdo.mybatis;


import com.hdo.mybatis.bean.Book;
import com.hdo.mybatis.bean.Loginnum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.cache.RedisCache;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatisApplicationTests {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private AmqpAdmin amqpAdmin;

    /*
     *@Author XWZ
     *@Description 单播点对点消息
     *@Date 2018/9/10 22:21
     **/
    @Test
    public void contextLoads(){
        //Manage 需要自己构造一个，定义消息内容和消息投 需要被序列化
        //rabbitTemplate.send(exchange,routeKey,message);

        //Object默认当成消息体，只需要传入要发送的对象，自动序列化发送rabbitMq
        //rabbitTempalte.convertAndSend(exchange,routeKey,Object)
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("msg","这是第一个消息队列！");
        map.put("date","我是你大爷");
        //对象被默认java序列化发送消息
        //交换器 路由件 消息
        rabbitTemplate.convertAndSend("exchange.direct","atguigu.news",map);
    }

    @Test
    public void receive(){
        //通过消息队列获取消息
        Object object=rabbitTemplate.receiveAndConvert("atguigu.news");
        System.out.println(object.getClass());
        System.out.println(object);
    }
    //广播 指定交换器 不用指定路由件
    @Test
    public void fanout(){
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("msg","这是第2个消息队列！");
        map.put("date","我是你大爷2");
        Book book=new Book("张三","李四","李四");
        rabbitTemplate.convertAndSend("amqpAmin.text2","",book);
    }

    @Test
    public void textAmqpAdmin(){
       //创建交换器
       amqpAdmin.declareExchange(new DirectExchange("amqpAdmin.exchange"));
       //创建队列 是否可持久化
       amqpAdmin.declareQueue(new Queue("amqpAdmin.queue",true));
       //创建绑定规则 绑定的对象 对象类型 绑定的交换器 路由件 mapcanshu
        amqpAdmin.declareBinding(new Binding("amqpAdmin.queue", Binding.DestinationType.QUEUE,"amqpAdmin.exchange","amqpAdmin",null));
    }

    @Test
    public void textAmqpAdmin1(){
        //创建交换器
        amqpAdmin.declareExchange(new FanoutExchange("amqpAmin.text1"));
        //创建队列 是否可持久化
        amqpAdmin.declareQueue(new Queue("atguigu.news",true));
        amqpAdmin.declareQueue(new Queue("atguigu",true));
        //创建绑定规则 绑定的对象 对象类型 绑定的交换器 路由件 mapcanshu
        amqpAdmin.declareBinding(new Binding("atguigu.news", Binding.DestinationType.QUEUE,"amqpAmin.text1","atguigu.news",null));
        amqpAdmin.declareBinding(new Binding("atguigu", Binding.DestinationType.QUEUE,"amqpAmin.text1","atguigu",null));
    }

    @Test
    public void textAmqpAdmin2(){
        //创建交换器
        amqpAdmin.declareExchange(new TopicExchange("amqpAmin.text2"));
        //创建队列 是否可持久化
        amqpAdmin.declareQueue(new Queue("atguigu.news",true));
        amqpAdmin.declareQueue(new Queue("atguigu",true));
        //创建绑定规则 绑定的对象 对象类型 绑定的交换器 路由件 mapcanshu
        amqpAdmin.declareBinding(new Binding("atguigu.news", Binding.DestinationType.QUEUE,"amqpAmin.text2","",null));
        amqpAdmin.declareBinding(new Binding("atguigu", Binding.DestinationType.QUEUE,"amqpAmin.text2","",null));
    }

    /*//操作字符串 K-V都是String
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    //K-V对象
    @Autowired
    private RedisTemplate redisTemplate;

    //K-V对象 从RedisConfig中获取对象 @Bean
    @Autowired
    private RedisTemplate<Object, Loginnum> loginnumRedisTemplate;

    *//**
     *Redis常见的五大数据类型
     * String(字符串),List(序列),Set(集合),Hash(散列),ZSet(有序集合)
     * redisTemplate.opsForValue(字符串);
     * redisTemplate.opsForList(序列);
     *
     * 1. 安装Redis：使用docker；
     * 2. 引入Redis的start
     * 3. 配置Redis
     * 4. 测试缓存
     *    原理.CacheManager == Cache 缓存组件来实际给缓存中存取数据
     *    1. 引入Redis的starter，容器中保存的是 RedisCacheManager
     *    2. RedisCacheManneger 帮我们创建 RedisCache 来作为缓存组件；RedisCache通过操作redis缓存数据
     **//*
    @Test
    public void Test1(){
        //向Redis中保存字符串
        stringRedisTemplate.opsForValue().append("msg","你是一个大傻子");
        //向Redis 中保存对象
        //默认 如果保存对象，使用jdk序列化保存机制，序列化的数据保存到Redis中
        //1.数据已JSON对象的方式保存 将自己的对象转为JSON
        //字符串序列化器
        RedisSerializer redisSerializer=new StringRedisSerializer();
        redisTemplate.setKeySerializer(redisSerializer);

        Loginnum loginnum=new Loginnum();
        loginnum.setDepartment("超级管理员");
        loginnum.setId(11);
        loginnum.setIpAddress("127.0.0.1");
        loginnum.setName("zhang sna ");
        loginnum.setNumber("158262751");

        //不转化的 会被序列化 获取值也不能用未被序列化的键中获取值
        redisTemplate.opsForValue().set("loginnum",loginnum);
    }

    //更改序列化器
    @Test
    public void Test2(){

        //2.数据已JSON对象的方式保存 将自己的对象转为JSON
        Loginnum loginnum=new Loginnum();
        loginnum.setDepartment("超级管理员");
        loginnum.setId(11);
        loginnum.setIpAddress("127.0.0.1");
        loginnum.setName("zhang sna ");
        loginnum.setNumber("158262751");

        //不转化的 会被序列化 获取值也不能用未被序列化的键中获取值
        loginnumRedisTemplate.opsForValue().set("loginnum",loginnum);
    }


    @Test
    public void contextLoads() {

        RedisSerializer redisSerializer=new StringRedisSerializer();
        redisTemplate.setKeySerializer(redisSerializer);
        Loginnum loginnum =(Loginnum) redisTemplate.opsForValue().get("loginnum");
        System.out.println(loginnum);
    }
*/
}
