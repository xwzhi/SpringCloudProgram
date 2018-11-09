package com.py.property.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * @ClassName WorkStatus
 * @Author XuWeiZhi
 * @Description
 * @Date 2018-11-02 09:23 星期五 property
 * @VERSION 1.0.0
 **/
@Entity
@Data
public class WorkStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;

    private String message;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<ManageItem> items;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private WorkStatusDetail workStatusDetail;

    public WorkStatus() {
    }

    public WorkStatus(String title, String message, Date createTime, Set<ManageItem> items, WorkStatusDetail workStatusDetail) {
        this.title = title;
        this.message = message;
        this.createTime = createTime;
        this.items = items;
        this.workStatusDetail = workStatusDetail;
    }
}
