package com.py.property.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * @ClassName Student
 * @Author XWZ
 * @Description
 * @Date 2018-09-02 22:39 星期日 SpringBootProgram
 * @VERSION 1.0.0
 **/
@Entity(name="student")
public class Student implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer sid;

    private String name;

    private String password;

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
