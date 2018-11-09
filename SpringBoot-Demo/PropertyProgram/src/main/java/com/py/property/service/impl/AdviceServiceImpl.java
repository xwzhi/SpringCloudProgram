package com.py.property.service.impl;

import com.py.property.entity.Advice;
import com.py.property.repository.AdviceDao;
import com.py.property.service.AdviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @ClassName AdviceServiceImpl
 * @Author XuWeiZhi
 * @Description
 * @Date 2018-11-02 17:09 星期五 property
 * @VERSION 1.0.0
 **/
@Service
@Transactional
public class AdviceServiceImpl implements AdviceService {

    @Autowired
    private AdviceDao adviceDao;

    @Override
    public void save(Advice advice) {
        adviceDao.save(advice);
    }

    @Override
    public void delete(Advice advice) {
        adviceDao.delete(advice);
    }

    @Override
    public Advice getById(Integer id) {
        return adviceDao.getOne(id);
    }

    @Override
    public List<Advice> findAll() {
        return adviceDao.findAll();
    }
}
