package com.springcloud.zuul.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;

/**
 * @ClassName CorsConfig
 * @Author XuWeiZhi
 * @Description ajax跨域请求设置
 * @Date 2018-11-09 00:35 星期五 MySpringCloud
 * @VERSION 1.0.0
 **/
@Configuration
public class CorsConfig {

    @Bean
    public CorsFilter corsFilter() {
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        final CorsConfiguration  config = new CorsConfiguration();

        //js跨域设置
        config.setAllowCredentials(true);//允许跨域
        config.setAllowedOrigins(Arrays.asList("*")); //http:www.a.com 允许跨域网站 *表示跨域所有网站
        config.setAllowedHeaders(Arrays.asList("*"));
        config.setAllowedMethods(Arrays.asList("*"));
        config.setMaxAge(300l); //表示300秒不对跨域进行请求

        //对所有请求进行跨域
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }
}
