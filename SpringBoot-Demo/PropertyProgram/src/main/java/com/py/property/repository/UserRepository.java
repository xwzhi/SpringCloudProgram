package com.py.property.repository;

import com.py.property.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @ClassName UserRepository
 * @Author XuWeiZhi
 * @Description
 * @Date 2018-10-29 14:39 星期一 MyProgram
 * @VERSION 1.0.0
 **/
public interface UserRepository extends JpaRepository<User, Integer>{

      User getUserByUsername(String username);
}
