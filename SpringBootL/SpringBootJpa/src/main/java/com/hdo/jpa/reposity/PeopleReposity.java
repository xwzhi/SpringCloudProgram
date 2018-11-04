package com.hdo.jpa.reposity;

import com.hdo.jpa.entity.People;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @ClassName PeopleReposity
 * @Author XWZ
 * @Description
 * @Date 2018-09-02 22:42 星期日 SpringBootProgram
 * @VERSION 1.0.0
 **/
@Repository
public interface PeopleReposity extends JpaRepository<People,Integer> {


}
