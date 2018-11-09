package com.py.property.service.impl;

import com.py.property.entity.Nav;
import com.py.property.repository.NavRepository;
import com.py.property.service.NavService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @ClassName NavServiceImpl
 * @Author XuWeiZhi
 * @Description
 * @Date 2018-11-01 15:00 星期四 property
 * @VERSION 1.0.0
 **/
@Service
@Transactional
public class NavServiceImpl implements NavService {

    @Autowired
    private NavRepository navRepository;

    @Override
    public void save(Nav nav) {
        navRepository.save(nav);
    }

    @Override
    public void delete(Nav nav) {
         navRepository.delete(nav);
    }

    @Override
    public Nav getById(Integer id) {
        return navRepository.getOne(id);
    }

    @Override
    public List<Nav> findAll() {
        return navRepository.findAll();
    }
    
}
