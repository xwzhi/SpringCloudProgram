package com.springboot.consumer.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @ClassName MyConfigure
 * @Description
 * @Author XWZ
 * @Date Create In 2018/8/13 12:01: 星期一 web
 * @Version 1.0.0
 **/
/*@Configuration*/
public class MyInterceptor implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/**").excludePathPatterns("/staitc/*");
    }
}
