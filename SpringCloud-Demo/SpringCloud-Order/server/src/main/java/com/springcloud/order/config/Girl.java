package com.springcloud.order.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

/**
 * @ClassName Config
 * @Author XuWeiZhi
 * @Description 从配置文件获取想要的数据
 * @Date 2018-10-11 15:28 星期四 Worklearn
 * @VERSION 1.0.0
 **/
@Data
@Component
@ConfigurationProperties("girl")
@RefreshScope//用于刷新配置
public class Girl {

    private String name;

    private Integer age;

}
