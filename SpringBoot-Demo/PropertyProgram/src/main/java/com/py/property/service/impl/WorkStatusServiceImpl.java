package com.py.property.service.impl;

import com.py.property.entity.WorkStatus;
import com.py.property.repository.WorkStatusRepository;
import com.py.property.service.WorkStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


/**
 * @ClassName WorkStatusServiceImpl
 * @Author XuWeiZhi
 * @Description
 * @Date 2018-11-02 10:05 星期五 property
 * @VERSION 1.0.0
 **/
@Service
@Transactional
public class WorkStatusServiceImpl implements WorkStatusService {

    @Autowired
    private WorkStatusRepository workStatusRepository;

    @Override
    public void save(WorkStatus workStatus) {
        workStatusRepository.save(workStatus);
    }

    @Override
    public void delete(WorkStatus workStatus) {
        workStatusRepository.delete(workStatus);
    }

    @Override
    public WorkStatus getById(Integer id) {
        return workStatusRepository.getOne(id);
    }

    @Override
    public List<WorkStatus> findAll() {
        return workStatusRepository.findAll();
    }
}
