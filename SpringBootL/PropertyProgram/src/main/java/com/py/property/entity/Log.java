package com.py.property.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * @ClassName Log
 * @Author XuWeiZhi
 * @Description 日志管理
 * @Date 2018-11-02 16:28 星期五 property
 * @VERSION 1.0.0
 **/
@Entity
@Data
public class Log {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    private String content;

    private Date createTime;

    private String type;

    @ManyToOne(optional = true, targetEntity = User.class, cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "l_id")
    private User user;

    public Log() {
    }

    public Log(User user, String content, Date createTime, String type) {
        this.user = user;
        this.content = content;
        this.createTime = createTime;
        this.type = type;
    }
}
