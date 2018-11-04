package com.py.property.repository;

import com.py.property.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @ClassName QuestionDao
 * @Author XuWeiZhi
 * @Description
 * @Date 2018-11-02 16:57 星期五 property
 * @VERSION 1.0.0
 **/
@Repository
public interface QuestionDao extends JpaRepository<Question,Integer> {

}
