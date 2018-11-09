package com.py.property.repository;

import com.py.property.entity.Nav;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @ClassName NavRepository
 * @Author XuWeiZhi
 * @Description
 * @Date 2018-11-01 14:57 星期四 property
 * @VERSION 1.0.0
 **/
@Repository
public interface NavRepository extends JpaRepository<Nav, Integer> {

}
