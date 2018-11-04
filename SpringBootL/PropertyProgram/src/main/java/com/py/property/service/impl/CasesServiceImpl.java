package com.py.property.service.impl;

import com.py.property.entity.Cases;
import com.py.property.repository.CasesDao;
import com.py.property.service.CasesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @ClassName CasesServiceImpl
 * @Author XuWeiZhi
 * @Description
 * @Date 2018-11-02 17:10 星期五 property
 * @VERSION 1.0.0
 **/
@Service
@Transactional
public class CasesServiceImpl implements CasesService {

    @Autowired
    private CasesDao casesDao;

    @Override
    public void save(Cases cases) {
        casesDao.save(cases);
    }

    @Override
    public void delete(Cases cases) {
        casesDao.delete(cases);
    }

    @Override
    public Cases getById(Integer id) {
        return casesDao.getOne(id);
    }

    @Override
    public List<Cases> findAll() {
        return casesDao.findAll();
    }
}
