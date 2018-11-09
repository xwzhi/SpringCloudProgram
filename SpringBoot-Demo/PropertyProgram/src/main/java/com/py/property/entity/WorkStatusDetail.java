package com.py.property.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.Date;

/**
 * @ClassName WorkStatusDetail
 * @Author XuWeiZhi
 * @Description
 * @Date 2018-11-06 14:35 星期二 MySpringCloud
 * @VERSION 1.0.0
 **/
@Entity
@Data
public class WorkStatusDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;

    private String resources;

    private String author;

    private String owner;

    private String newsType;

    /*@Column(name = "content", columnDefinition = "text")*/
    private String content;

    private Boolean isAdvantage;

    private String imgUrl;

    private Date releaseTime;

    private Date outTime;

    public WorkStatusDetail() {
    }

    public WorkStatusDetail(String title, String resources, String author, String owner, String newsType, String content, Boolean isAdvantage, String imgUrl, Date releaseTime, Date outTime) {
        this.title = title;
        this.resources = resources;
        this.author = author;
        this.owner = owner;
        this.newsType = newsType;
        this.content = content;
        this.isAdvantage = isAdvantage;
        this.imgUrl = imgUrl;
        this.releaseTime = releaseTime;
        this.outTime = outTime;
    }
}
