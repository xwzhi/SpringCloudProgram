package com.py.property.service.impl;

import com.py.property.entity.WorkReport;
import com.py.property.repository.WorkReportRepository;
import com.py.property.service.WorkReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @ClassName WorkReportServiceImpl
 * @Author XuWeiZhi
 * @Description
 * @Date 2018-11-02 10:03 星期五 property
 * @VERSION 1.0.0
 **/
@Service
@Transactional
public class WorkReportServiceImpl implements WorkReportService {

    @Autowired
    private WorkReportRepository workReportRepository;

    @Override
    public void save(WorkReport workReport) {
        workReportRepository.save(workReport);
    }

    @Override
    public void delete(WorkReport workReport) {
        workReportRepository.delete(workReport);
    }

    @Override
    public WorkReport getById(Integer id) {
        return workReportRepository.getOne(id);
    }

    @Override
    public List<WorkReport> findAll() {
        return workReportRepository.findAll();
    }
}
