package com.boot.design.reflect;

import java.util.Date;

/**
 * @ClassName User
 * @Author XuWeiZhi
 * @Description
 * @Date 2018-09-20 08:50 星期四 My1Program
 * @VERSION 1.0.0
 **/
public class User {

    private String username;

    private String password;

    private Date time;

    public User() {
    }

    public User(String username, String password, Date time) {
        this.username = username;
        this.password = password;
        this.time = time;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        System.out.println(username);
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", time=" + time +
                '}';
    }
}
