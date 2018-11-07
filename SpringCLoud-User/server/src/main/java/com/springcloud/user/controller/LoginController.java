package com.springcloud.user.controller;

import com.springcloud.user.constant.CookieConstant;
import com.springcloud.user.constant.RedisConstant;
import com.springcloud.user.entity.UserInfo;
import com.springcloud.user.utils.CookieUtils;
import com.springcloud.user.enums.ResultEnum;
import com.springcloud.user.enums.RoleEnum;
import com.springcloud.user.service.UserInfoService;
import com.springcloud.user.utils.ResultVOUtil;
import com.springcloud.user.vo.ResultVO;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName LoginController
 * @Author XuWeiZhi
 * @Description
 * @Date 2018-11-07 23:51 星期三 MySpringCloud
 * @VERSION 1.0.0
 **/
@RestController
@RequestMapping("/user")
public class LoginController {

    @Autowired
    private UserInfoService userService;

    @Autowired
    private StringRedisTemplate redisTemplate;

    /*买家登录*/
    @GetMapping("/buyer")
    private ResultVO buyer(@RequestParam("openid") String openid, HttpServletResponse response) {
        //1.openid和数据库里的数据进行匹配
        UserInfo userInfo = userService.getUserByOpenid(openid);
        if (userInfo == null) {
            return ResultVOUtil.error(ResultEnum.LOGIN_FAIL);
        }
        //2.判断角色
        if (userInfo.getRole() != RoleEnum.BUYER.getCode()) {
            return ResultVOUtil.error(ResultEnum.ROLE_ERROR);
        }
        //3.cookie设置openid==abc
        CookieUtils.set(response, CookieConstant.OPENID, openid, CookieConstant.EXPIRE);
        return ResultVOUtil.success();
    }

    /*卖家登陆*/
    @GetMapping("/seller")
    private ResultVO seller(@RequestParam("openid") String openid, HttpServletResponse response, HttpServletRequest request) {
        //1.openid和数据库里的数据进行匹配
        Cookie cookie = CookieUtils.get(request, CookieConstant.TOKEN);
        if(cookie!=null && StringUtils.isNotEmpty(redisTemplate.opsForValue().get( String.format(RedisConstant.TOKEN_TEMPLATE, cookie.getValue())))){
            return ResultVOUtil.success();
        }
        UserInfo userInfo = userService.getUserByOpenid(openid);
        if (userInfo == null) {
            return ResultVOUtil.error(ResultEnum.LOGIN_FAIL);
        }
        //2.判断角色
        if (userInfo.getRole() != RoleEnum.SELLER.getCode()) {
            return ResultVOUtil.error(ResultEnum.ROLE_ERROR);
        }
        //3.设置Cookie key=UUID value=xyz
        String token = UUID.randomUUID().toString();
        Integer expire = CookieConstant.EXPIRE;
        redisTemplate.opsForValue().set(
                String.format(RedisConstant.TOKEN_TEMPLATE, token),
                openid,
                expire,
                TimeUnit.SECONDS);
        //4.cookie设置openid==abc
        CookieUtils.set(response, CookieConstant.TOKEN, token, CookieConstant.EXPIRE);
        return ResultVOUtil.success();
    }
}
