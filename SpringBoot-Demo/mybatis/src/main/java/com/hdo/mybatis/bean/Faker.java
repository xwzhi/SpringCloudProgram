package com.hdo.mybatis.bean;

import io.searchbox.annotations.JestId;

/**
 * @ClassName Faker
 * @Author XuWeiZhi
 * @Description
 * @Date 2018-09-11 22:35 星期二 SpringBootProgram
 * @VERSION 1.0.0
 **/
public class Faker {

    @JestId
    private Integer id;

    private String name;

    private String world;

    private String age;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWorld() {
        return world;
    }

    public void setWorld(String world) {
        this.world = world;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
