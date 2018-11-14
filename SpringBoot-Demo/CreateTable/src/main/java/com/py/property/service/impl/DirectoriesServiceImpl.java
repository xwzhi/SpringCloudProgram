package com.py.property.service.impl;

import com.py.property.entity.Directories;
import com.py.property.repository.DirectoriesDao;
import com.py.property.service.DirectoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @ClassName DirectoriesServiceImpl
 * @Author XuWeiZhi
 * @Description
 * @Date 2018-11-02 17:10 星期五 property
 * @VERSION 1.0.0
 **/
@Service
@Transactional
public class DirectoriesServiceImpl implements DirectoriesService {

    @Autowired
    private DirectoriesDao directoriesDao;

    @Override
    public void save(Directories directories) {
        directoriesDao.save(directories);
    }

    @Override
    public void delete(Directories directories) {
        directoriesDao.delete(directories);
    }

    @Override
    public Directories getById(Integer id) {
        return directoriesDao.getOne(id);
    }

    @Override
    public List<Directories> findAll() {
        return directoriesDao.findAll();
    }
}
