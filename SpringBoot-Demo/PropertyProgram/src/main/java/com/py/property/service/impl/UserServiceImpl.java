package com.py.property.service.impl;

import com.py.property.entity.User;
import com.py.property.repository.UserRepository;
import com.py.property.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @ClassName UserServiceImpl
 * @Author XuWeiZhi
 * @Description
 * @Date 2018-10-29 14:37 星期一 MyProgram
 * @VERSION 1.0.0
 **/
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User login(User user) {
        return userRepository.getUserByUsername(user.getUsername());
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public void delete(User user) {
      userRepository.delete(user);
    }

    @Override
    public User getById(Integer id) {
        return userRepository.getOne(id);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

}
