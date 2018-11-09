package com.py.property.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

/**
 * @ClassName Nav
 * @Author XuWeiZhi
 * @Description 页面头部导航栏
 * @Date 2018-11-01 14:53 星期四 property
 * @VERSION 1.0.0
 **/
@Entity
@Data
public class Nav {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    //导航栏名称
    private String name;

    //链接地址
    private String link;

    //链接样式
    private String icon;

    //是否显示子类
    private Boolean isShowChildren;

    //是否被激活
    private Boolean isActive;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Set<NavItem> navItems;

    public Nav(String name, String link, Boolean isActive) {
        this.name = name;
        this.link = link;
        this.isActive = isActive;
    }

    public Nav() {

    }

    /*childrens: Array<Nav>;*/
}
