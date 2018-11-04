package com.hdo.jpa.reposity;

import com.hdo.jpa.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @ClassName StudentReposity
 * @Author XWZ
 * @Description
 * @Date 2018-09-02 23:38 星期日 SpringBootProgram
 * @VERSION 1.0.0
 **/
@Repository
public interface StudentReposity extends JpaRepository<Student,Integer> {
}
