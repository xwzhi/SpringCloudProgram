package com.springcloud.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableEurekaClient
@EnableScheduling
//把服务端的接口放在了客户端
@EnableFeignClients(basePackages = "com.springcloud.product.client")
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
