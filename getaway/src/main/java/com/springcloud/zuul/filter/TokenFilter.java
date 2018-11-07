package com.springcloud.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_DECORATION_FILTER_ORDER;
import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;

/**
 * @ClassName TokenFilter
 * @Author XuWeiZhi
 * @Description 访问权限控制
 * @Date 2018-11-07 20:42 星期三 MySpringCloud
 * @VERSION 1.0.0
 **/
@Component
public class TokenFilter extends ZuulFilter {


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
        /*从URL中获取参数，也可以从Cookie,Header*/
        String token = request.getParameter("token");
        if (StringUtils.isEmpty(token)) {
            ///*token不存在，不允许访问路径*/
            //currentContext.setSendZuulResponse(false);
            ///*设置返回失败状态码，一般权限不足对应的状态码401*/
            //currentContext.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());
        }
        return null;
    }

}
