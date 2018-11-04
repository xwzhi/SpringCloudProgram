package com.hdo.jpa;

import com.hdo.jpa.entity.People;
import com.hdo.jpa.entity.Student;
import com.hdo.jpa.reposity.PeopleReposity;
import com.hdo.jpa.reposity.StudentReposity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JpaApplicationTests {

    @Autowired
    private PeopleReposity peopleReposity;

    @Autowired
    private StudentReposity studentReposity;

    @Test
    public void contextLoads() {
        People people=new People();
        Student student=new Student();

        student.setName("张三");
        student.setPassword("xxx");

        people.setSname("清华大学");
        people.setBirth(new Date());
        people.setTime(new Date());

        student.setPeople(people);

        studentReposity.save(student);
    }

    @Test
    public void s() {
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        List<Student> all = studentReposity.findAll();
        System.out.println();
    }

}
