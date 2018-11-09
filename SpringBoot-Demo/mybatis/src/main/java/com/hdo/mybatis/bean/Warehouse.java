package com.hdo.mybatis.bean;

import java.io.Serializable;

/**
 * @ClassName Warehouse
 * @Author XWZ
 * @Description
 * @Date 2018-09-09 22:04 星期日 SpringBootProgram
 * @VERSION 1.0.0
 **/
public class Warehouse implements Serializable {

    private Integer id;

    private String address;

    private String name;

    private Integer number;

    private String shelves;

    private Integer manager;

    private String zone;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getShelves() {
        return shelves;
    }

    public void setShelves(String shelves) {
        this.shelves = shelves;
    }

    public Integer getManager() {
        return manager;
    }

    public void setManager(Integer manager) {
        this.manager = manager;
    }

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    @Override
    public String toString() {
        return "Warehouse{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", name='" + name + '\'' +
                ", number=" + number +
                ", shelves='" + shelves + '\'' +
                ", manager='" + manager + '\'' +
                ", zone='" + zone + '\'' +
                '}';
    }
}
