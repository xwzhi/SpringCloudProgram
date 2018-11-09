package com.py.property.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * @ClassName Product
 * @Author XuWeiZhi
 * @Description
 * @Date 2018-10-26 13:13 星期五 MyProgram
 * @VERSION 1.0.0
 **/
@Entity
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;

    private BigDecimal price;

    private BigDecimal rating;

    private String descrs;

    public Product() {
    }

}
