package com.py.property.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * @ClassName User
 * @Author XuWeiZhi
 * @Description
 * @Date 2018-10-29 13:49 星期一 MyProgram
 * @VERSION 1.0.0
 **/
@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; //主键Id

    private String username; //用户名

    private String password; // 密码

    private String phoneNumber; //电话号码

    private String address; //地址

    private Date createTime; //创造时间

}
