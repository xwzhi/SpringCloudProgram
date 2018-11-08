package com.springcloud.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import com.springcloud.common.constant.RedisConstant;
import com.springcloud.common.utils.CookieUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.http.Cookie;
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
public class AuthBuyerFilter extends ZuulFilter {

    @Autowired
    private StringRedisTemplate redisTemplate;

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

    /**
     * 是否拦截
     */
    @Override
    public boolean shouldFilter() {
        RequestContext currentContext = RequestContext.getCurrentContext();
        HttpServletRequest request = currentContext.getRequest();
        /*返回true代表执行run方法，表示拦截*/
        if ("/order/order/create".equals(request.getRequestURI())) {
            return true;
        }
        return false;
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
          /order/create 只能买家访问(Cookie有openid)
         */
        Cookie cookie = CookieUtils.get(request, "openid");
        if (cookie == null || StringUtils.isEmpty(cookie.getValue())) {
            currentContext.setSendZuulResponse(false);
            currentContext.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());
        }

        return null;
    }

}
