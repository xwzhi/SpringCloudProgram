package com.py.property.service.impl;

import com.py.property.entity.Log;
import com.py.property.repository.LogDao;
import com.py.property.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @ClassName LogServiceImpl
 * @Author XuWeiZhi
 * @Description
 * @Date 2018-11-02 17:11 星期五 property
 * @VERSION 1.0.0
 **/
@Service
@Transactional
public class LogServiceImpl implements LogService {

    @Autowired
    private LogDao logDao;

    @Override
    public void save(Log log) {
        logDao.save(log);
    }

    @Override
    public void delete(Log log) {
        logDao.delete(log);
    }

    @Override
    public Log getById(Integer id) {
        return logDao.getOne(id);
    }

    @Override
    public List<Log> findAll() {
        return logDao.findAll();
    }
}
