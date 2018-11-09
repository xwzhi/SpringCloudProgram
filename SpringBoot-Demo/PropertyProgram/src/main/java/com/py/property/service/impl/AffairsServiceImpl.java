package com.py.property.service.impl;

import com.py.property.entity.Affairs;
import com.py.property.repository.AffairsDao;
import com.py.property.service.AffairsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @ClassName AffairsServiceImpl
 * @Author XuWeiZhi
 * @Description
 * @Date 2018-11-02 17:10 星期五 property
 * @VERSION 1.0.0
 **/
@Service
@Transactional
public class AffairsServiceImpl implements AffairsService {

    @Autowired
    private AffairsDao affairsDao;

    @Override
    public void save(Affairs affairs) {
        affairsDao.save(affairs);
    }

    @Override
    public void delete(Affairs affairs) {
        affairsDao.delete(affairs);
    }

    @Override
    public Affairs getById(Integer id) {
        return affairsDao.getOne(id);
    }

    @Override
    public List<Affairs> findAll() {
        return affairsDao.findAll();
    }
}
