package com.py.property.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * @ClassName NavItem
 * @Author XuWeiZhi
 * @Description 左侧导航栏
 * @Date 2018-11-01 16:29 星期四 property
 * @VERSION 1.0.0
 **/
@Entity
@Data
public class NavItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String link;

    public NavItem() {
    }

    public NavItem(String name, String link) {
        this.name = name;
        this.link = link;
    }
}
