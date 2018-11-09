package com.py.property.repository;

import com.py.property.entity.WorkStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @ClassName WorkStatusRepository
 * @Author XuWeiZhi
 * @Description
 * @Date 2018-11-02 10:02 星期五 property
 * @VERSION 1.0.0
 **/
@Repository
public interface WorkStatusRepository extends JpaRepository<WorkStatus,Integer> {

}
