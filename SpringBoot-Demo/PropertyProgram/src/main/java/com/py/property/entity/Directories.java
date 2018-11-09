package com.py.property.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * @ClassName Directories
 * @Author XuWeiZhi
 * @Description 名录
 * @Date 2018-11-02 16:27 星期五 property
 * @VERSION 1.0.0
 **/
@Entity
@Data
public class Directories {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;

    private String message;

    private String address;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<ManageItem> items;

    public Directories() {
    }

    public Directories(String title, String message, String address, Date createTime, Set<ManageItem> items) {
        this.title = title;
        this.message = message;
        this.address = address;
        this.createTime = createTime;
        this.items = items;
    }
}
