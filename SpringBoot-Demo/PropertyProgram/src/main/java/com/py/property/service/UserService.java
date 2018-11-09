package com.py.property.service;

import com.py.property.entity.User;

/**
 * @ClassName UserService
 * @Author XuWeiZhi
 * @Description
 * @Date 2018-10-29 13:53 星期一 MyProgram
 * @VERSION 1.0.0
 **/
public interface UserService extends BaseService<User> {


    /*登录校验*/
    User login(User user);

}
