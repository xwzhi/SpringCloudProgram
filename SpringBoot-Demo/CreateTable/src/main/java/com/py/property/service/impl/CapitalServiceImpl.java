package com.py.property.service.impl;

import com.py.property.entity.Capital;
import com.py.property.repository.CapitalDao;
import com.py.property.service.CapitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @ClassName CapitalServiceImpl
 * @Author XuWeiZhi
 * @Description
 * @Date 2018-11-02 17:10 星期五 property
 * @VERSION 1.0.0
 **/
@Service
@Transactional
public class CapitalServiceImpl implements CapitalService {

    @Autowired
    private CapitalDao capitalDao;

    @Override
    public void save(Capital Capital) {
        capitalDao.save(Capital);
    }

    @Override
    public void delete(Capital capital) {
        capitalDao.delete(capital);
    }

    @Override
    public Capital getById(Integer id) {
        return capitalDao.getOne(id);
    }

    @Override
    public List<Capital> findAll() {
        return capitalDao.findAll();
    }
}
