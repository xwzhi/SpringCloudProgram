package com.springcloud.user.service;

import com.springcloud.user.entity.UserInfo;

/**
 * @ClassName UserInfoService
 * @Author XuWeiZhi
 * @Description
 * @Date 2018-11-07 23:44 星期三 MySpringCloud
 * @VERSION 1.0.0
 **/
public interface UserInfoService {

    UserInfo getUserByOpenid(String openid);

}
