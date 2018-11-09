package com.springcloud.user.dao;

import com.springcloud.user.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @ClassName UserDao
 * @Author XuWeiZhi
 * @Description
 * @Date 2018-11-07 23:42 星期三 MySpringCloud
 * @VERSION 1.0.0
 **/
@Repository
public interface UserInfoDao extends JpaRepository<UserInfo, Integer> {

    UserInfo findByOpenid(String id);

}
