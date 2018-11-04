package com.py.property.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * @ClassName Complaint
 * @Author XuWeiZhi
 * @Description 投诉
 * @Date 2018-11-02 16:27 星期五 property
 * @VERSION 1.0.0
 **/
@Entity
@Data
public class Complaint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;

    private String message;

    private String objectOfComplaint;

    private String nameOfComplainant;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<ManageItem> items;

    public Complaint() {
    }

    public Complaint(String title, String message, String objectOfComplaint, String nameOfComplainant, Date createTime, Set<ManageItem> items) {
        this.title = title;
        this.message = message;
        this.objectOfComplaint = objectOfComplaint;
        this.nameOfComplainant = nameOfComplainant;
        this.createTime = createTime;
        this.items = items;
    }
}
