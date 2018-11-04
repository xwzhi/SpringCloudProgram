package com.hdo.mybatis.config;

import com.hdo.mybatis.fliter.MyFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName MyMvcConfig
 * @Author XWZ
 * @Description
 * @Date 2018-08-22 17:01 星期三 01-SpringBoot-Web
 * @VERSION 1.0.0
 **/
//@EnableWebMvc Spring自动配置将全面失效
@Configuration
public class MyMvcConfigure implements WebMvcConfigurer {

    /**
     * 配置拦截路径 设置返回路径
     * 所有视图拦截都会有效果
     * @param registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/main.html").setViewName("main");
        registry.addViewController("/index.html").setViewName("login");
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/index").setViewName("login");
    }

    @Bean
    public FilterRegistrationBean myFilter(){
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new MyFilter());
        registrationBean.addUrlPatterns("/*");
        return registrationBean;
    }

}
