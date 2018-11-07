package com.springcloud.user.service.serviceimpl;

import com.springcloud.user.dao.UserInfoDao;
import com.springcloud.user.entity.UserInfo;
import com.springcloud.user.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * @ClassName UserServiceImpl
 * @Author XuWeiZhi
 * @Description
 * @Date 2018-11-07 23:46 星期三 MySpringCloud
 * @VERSION 1.0.0
 **/
@Service
@Transactional
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoDao userDao;

    @Override
    public UserInfo getUserByOpenid(String openid) {
        return userDao.findByOpenid(openid);
    }
}
