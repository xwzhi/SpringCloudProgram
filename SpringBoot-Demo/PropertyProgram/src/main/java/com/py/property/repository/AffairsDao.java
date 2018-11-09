package com.py.property.repository;

import com.py.property.entity.Affairs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @ClassName AffairsDao
 * @Author XuWeiZhi
 * @Description
 * @Date 2018-11-02 16:55 星期五 property
 * @VERSION 1.0.0
 **/
@Repository
public interface AffairsDao extends JpaRepository<Affairs,Integer> {
}
