package com.springcloud.zuul.filter;

import com.google.common.util.concurrent.RateLimiter;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;
import com.springcloud.zuul.exception.RateLimiterException;
import org.springframework.stereotype.Component;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;
import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.SERVLET_DETECTION_FILTER_ORDER;

/**
 * @ClassName RateFilter
 * @Author XuWeiZhi
 * @Description 请求限流
 * @Date 2018-11-07 21:28 星期三 MySpringCloud
 * @VERSION 1.0.0
 **/
@Component
public class RateLimiterFilter extends ZuulFilter {

    /*
      Goole开元限流组件
      每秒钟向里面放100个令牌
     */
    private static final RateLimiter RATE_LIMITER = RateLimiter.create(100);
    @Override
    public String filterType() {
        return PRE_TYPE;
    }

    /*
      确定优先级顺序，数字越小，优先级越高
     */
    @Override
    public int filterOrder() {
        return SERVLET_DETECTION_FILTER_ORDER -1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    /*
      思路：1.RATE_LIMITER 每秒秒钟已固定速率向盒子中放令牌
           2.执行体判断是够能够拿到领票。
           3.如果不能拿到令牌，说明请求过多，不能访问此URL
     */
    @Override
    public Object run() throws ZuulException {
        //如果没有获取到令牌，则抛出异常或者请求错误
        if(!RATE_LIMITER.tryAcquire()){
            throw new RateLimiterException();
        }
        return null;
    }
}
