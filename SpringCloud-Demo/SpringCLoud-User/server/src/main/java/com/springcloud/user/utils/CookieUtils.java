package com.springcloud.user.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName CookieUtils
 * @Author XuWeiZhi
 * @Description
 * @Date 2018-11-08 00:11 星期四 MySpringCloud
 * @VERSION 1.0.0
 **/
public class CookieUtils {

    public static void set(HttpServletResponse response,String name, String value, int maxAge){
        Cookie cookie = new Cookie(name,value);
        cookie.setPath("/");
        cookie.setMaxAge(maxAge);
        response.addCookie(cookie);
    }

    public static Cookie get(HttpServletRequest request,String name){
        Cookie [] cookies = request.getCookies();
        if(cookies!=null){
            for (Cookie cookie : cookies) {
                if(name.equals(cookie.getName())){
                    return cookie;
                }
            }
        }
        return null;
    }
}
