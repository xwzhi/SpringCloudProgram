package com.py.property.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @ClassName ManageItem
 * @Author XuWeiZhi
 * @Description
 * @Date 2018-11-02 09:28 星期五 property
 * @VERSION 1.0.0
 **/
@Entity
@Data
public class ManageItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer code;

    private String operation;

    public ManageItem() {

    }

    public ManageItem(Integer code, String operation) {
        this.code = code;
        this.operation = operation;
    }

}
