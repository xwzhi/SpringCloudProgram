package com.py.property.repository;

import com.py.property.entity.Capital;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @ClassName CapitalDao
 * @Author XuWeiZhi
 * @Description
 * @Date 2018-11-02 16:55 星期五 property
 * @VERSION 1.0.0
 **/
@Repository
public interface CapitalDao extends JpaRepository<Capital,Integer> {
}
