package com.springcloud.zuul.exception;

/**
 * @ClassName RateLimiterException
 * @Author XuWeiZhi
 * @Description
 * @Date 2018-11-07 21:39 星期三 MySpringCloud
 * @VERSION 1.0.0
 **/
public class RateLimiterException extends RuntimeException {

    public RateLimiterException() {
        super("请求次数过多，请摆正你的态度。");
    }
}
