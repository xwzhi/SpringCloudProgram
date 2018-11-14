package com.py.property.repository;

import com.py.property.entity.Policy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @ClassName PolicyDao
 * @Author XuWeiZhi
 * @Description
 * @Date 2018-11-02 16:57 星期五 property
 * @VERSION 1.0.0
 **/
@Repository
public interface PolicyDao extends JpaRepository<Policy,Integer> {
}
