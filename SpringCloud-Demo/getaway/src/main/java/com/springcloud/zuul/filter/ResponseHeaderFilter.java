package com.springcloud.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;


import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.POST_TYPE;
import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.SEND_RESPONSE_FILTER_ORDER;

/**
 * @ClassName ReponseHeaderFilter
 * @Author XuWeiZhi
 * @Description 返回值
 * @Date 2018-11-07 21:16 星期三 MySpringCloud
 * @VERSION 1.0.0
 **/
@Component
public class ResponseHeaderFilter extends ZuulFilter {

    /*返回过滤加值*/
    @Override
    public String filterType() {
        return POST_TYPE;
    }

    @Override
    public int filterOrder() {
        return SEND_RESPONSE_FILTER_ORDER - 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletResponse response = requestContext.getResponse();
        response.setCharacterEncoding("UTF-8");
        response.setHeader("Hello", "来自服务器的问候！");
        return null;
    }
}
