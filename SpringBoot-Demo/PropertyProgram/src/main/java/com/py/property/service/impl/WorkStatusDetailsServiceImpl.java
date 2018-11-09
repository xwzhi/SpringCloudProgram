package com.py.property.service.impl;

import com.py.property.entity.WorkStatus;
import com.py.property.entity.WorkStatusDetail;
import com.py.property.repository.WorStatusDetailsRepository;
import com.py.property.repository.WorkStatusRepository;
import com.py.property.service.WorkStatusDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @ClassName WorkStatusDetailsServiceImpl
 * @Author XuWeiZhi
 * @Description
 * @Date 2018-11-06 14:56 星期二 MySpringCloud
 * @VERSION 1.0.0
 **/
@Service
@Transactional
public class WorkStatusDetailsServiceImpl implements WorkStatusDetailService {

    @Autowired
    private WorStatusDetailsRepository repository;

    @Override
    public void save(WorkStatusDetail workStatus) {
        repository.save(workStatus);
    }

    @Override
    public void delete(WorkStatusDetail workStatus) {
        repository.delete(workStatus);
    }

    @Override
    public WorkStatusDetail getById(Integer id) {
        return repository.getOne(id);
    }

    @Override
    public List<WorkStatusDetail> findAll() {
        return repository.findAll();
    }
}
