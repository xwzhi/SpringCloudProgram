package com.springcloud.order;

import brave.sampler.Sampler;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;



@EnableScheduling
//把服务端的接口放在了客户端
@EnableFeignClients(basePackages = "com.springcloud.product.client")
@ComponentScan(basePackages = "com.springcloud") //product服务配置了组件，所以进行包扫描o
@SpringCloudApplication  //@SpringBootApplication @EnableDiscoveryClient 客户端 @EnableCircuitBreaker Hystrix 启动注解
@EnableHystrixDashboard  //hystrix可视化界面  http://localhost:8082/hystrix
//@EnableHystrix
//@EnableBinding(StreamInput.class)
public class OrderApplication {

	//@StreamListener(StreamInput.INPUT)
	//public void input(Message<String> message) {
	//	System.out.println("一般监听收到：" + message.getPayload());
	//}


	public static void main(String[] args) {
		SpringApplication.run(OrderApplication.class, args);
	}

	//#Hystrix可視化监控 默认有上下文 http://localhost:8082/actuator/hystrix.stream
	//@Bean
	/*public ServletRegistrationBean getServlet() {
		HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
		ServletRegistrationBean registrationBean = new ServletRegistrationBean(streamServlet);
		registrationBean.setLoadOnStartup(1);
		registrationBean.addUrlMappings("/hystrix.stream");
		registrationBean.setName("HystrixMetricsStreamServlet");
		return registrationBean;
	}*/

	@Bean
	public Sampler defaultSampler() {
		return Sampler.ALWAYS_SAMPLE;
	}

}
