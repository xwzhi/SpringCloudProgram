package com.py.property.repository;

import com.py.property.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @ClassName ProductRepository
 * @Author XuWeiZhi
 * @Description
 * @Date 2018-10-26 15:00 星期五 MyProgram
 * @VERSION 1.0.0
 **/
@Repository
public interface ProductRepository extends JpaRepository<Product ,Integer> {

}
