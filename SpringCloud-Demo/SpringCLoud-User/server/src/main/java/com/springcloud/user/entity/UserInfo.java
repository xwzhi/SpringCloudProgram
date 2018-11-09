package com.springcloud.user.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @ClassName UserInfo
 * @Author XuWeiZhi
 * @Description
 * @Date 2018-11-07 23:39 星期三 MySpringCloud
 * @VERSION 1.0.0
 **/
@Data
@Entity
public class UserInfo {

    @Id
    private String id;

    private String username;

    private String password;

    private String openid;

    private Integer role;
}
