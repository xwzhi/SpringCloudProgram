package com.hdo.jpa.entity;

import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 * @ClassName People
 * @Author XWZ
 * @Description
 * @Date 2018-09-02 22:36 星期日 SpringBootProgram
 * @VERSION 1.0.0
 **/
@Entity(name = "sdfsdfsdfs")
public class People implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer pid;

    private String sname;

    private Date time;

    private Date birth;

    @Temporal(TemporalType.DATE)
    public Date getTime() {
        return time;
    }

    //设置时间戳格式
    //@Basic 默认存在
    public void setTime(Date time) {
        this.time = time;
    }
    @Temporal(TemporalType.TIMESTAMP)
    public Date getBirth() {
        return birth;
    }


    public void setBirth(Date birth) {
        this.birth = birth;
    }

    /*//放弃主键维护
    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
    @JoinColumn(name = "people_id")
    private Set<Student> students;*/

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }
    //不生成对应表结构字段
    @Transient
    public String getInfo(){
      return "xx";
    }

    @Override
    public String toString() {
        return "People{" +
                "pid=" + pid +
                ", sname='" + sname + '\'' +
                ", time=" + time +
                ", birth=" + birth +
                '}';
    }
}
