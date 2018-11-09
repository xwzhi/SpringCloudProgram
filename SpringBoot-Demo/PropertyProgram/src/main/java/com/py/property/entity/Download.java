package com.py.property.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * @ClassName Download
 * @Author XuWeiZhi
 * @Description
 * @Date 2018-11-02 16:26 星期五 property
 * @VERSION 1.0.0
 **/
@Entity
@Data
public class Download {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;

    private String message;

    private String fileSize;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<ManageItem> items;

    public Download() {
    }

    public Download(String title, String message, String fileSize, Date createTime, Set<ManageItem> items) {
        this.title = title;
        this.message = message;
        this.fileSize = fileSize;
        this.createTime = createTime;
        this.items = items;
    }
}
