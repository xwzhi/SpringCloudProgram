package com.py.property.VO;

import lombok.Data;

import java.util.Date;

/**
 * @ClassName WSDetailsVo
 * @Author XuWeiZhi
 * @Description
 * @Date 2018-11-06 15:50 星期二 MySpringCloud
 * @VERSION 1.0.0
 **/
@Data
public class WSDetailsVo {

    private Integer id;

    private String title;

    private String resources;

    private String author;

    private String owner;

    private String newsType;

    private String content;

    private Boolean isAdvantage;

    private String imgUrl;

    private Date releaseTime;

    private Date outTime;

    public WSDetailsVo() {
    }

    public WSDetailsVo(String title, String resources, String author, String owner, String newsType, String content, Boolean isAdvantage, String imgUrl, Date releaseTime, Date outTime) {
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
