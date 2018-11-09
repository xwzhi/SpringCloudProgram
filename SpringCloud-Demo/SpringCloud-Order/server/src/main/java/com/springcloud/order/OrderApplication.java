package com.springcloud.order;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
//把服务端的接口放在了客户端
@EnableFeignClients(basePackages = "com.springcloud.product.client")
@SpringCloudApplication  //@SpringBootApplication @EnableDiscoveryClient 客户端 @EnableCircuitBreaker Hystrix 启动注解
//@EnableBinding(StreamInput.class)
public class OrderApplication {

	//@StreamListener(StreamInput.INPUT)
	//public void input(Message<String> message) {
	//	System.out.println("一般监听收到：" + message.getPayload());
	//}


	public static void main(String[] args) {
		SpringApplication.run(OrderApplication.class, args);
	}

}
