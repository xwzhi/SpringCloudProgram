package com.springcloud.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_DECORATION_FILTER_ORDER;
import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;

/**
 * @ClassName TokenFilter
 * @Author XuWeiZhi
 * @Description 权限拦截 区分买家和买家的权限
 * @Date 2018-11-07 20:42 星期三 MySpringCloud
 * @VERSION 1.0.0
 **/
@Component
public class AuthFilter extends ZuulFilter {


    /**
     * 返回拦截类型 zuul处理之前拦截过滤
     */
    @Override
    public String filterType() {
        return PRE_TYPE;
    }

    /**
     * 拦截顺序，越小的越靠前
     */
    @Override
    public int filterOrder() {
        return PRE_DECORATION_FILTER_ORDER - 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    /*
      实现的逻辑
     */
    @Override
    public Object run() throws ZuulException {
        /*获取当前对象的上下文*/
        RequestContext currentContext = RequestContext.getCurrentContext();
        HttpServletRequest request = currentContext.getRequest();

        /*
          /order/create 只能买家访问
          /order/finish 只能卖家访问
          /product/list 都能访问
         */
        return null;
    }

}
