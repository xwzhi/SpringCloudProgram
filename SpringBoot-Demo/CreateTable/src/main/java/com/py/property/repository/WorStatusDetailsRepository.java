package com.py.property.repository;

import com.py.property.entity.WorkStatus;
import com.py.property.entity.WorkStatusDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @ClassName WorStatusDetailsResponsitory
 * @Author XuWeiZhi
 * @Description
 * @Date 2018-11-06 14:50 星期二 MySpringCloud
 * @VERSION 1.0.0
 **/
@Repository
public interface WorStatusDetailsRepository extends JpaRepository<WorkStatusDetail, Integer> {

}
