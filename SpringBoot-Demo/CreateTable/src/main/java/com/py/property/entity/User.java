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
    private Integer id;

    private String username;

    private String password;

    private String address;

    private String phoneNumber;

    private Integer role;

    private Date createTime;

    private String apartment;

}
