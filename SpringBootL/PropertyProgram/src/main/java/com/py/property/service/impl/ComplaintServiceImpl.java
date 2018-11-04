package com.py.property.service.impl;

import com.py.property.entity.Complaint;
import com.py.property.repository.ComplaintDao;
import com.py.property.service.ComplaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @ClassName ComplaintServiceImpl
 * @Author XuWeiZhi
 * @Description
 * @Date 2018-11-02 17:10 星期五 property
 * @VERSION 1.0.0
 **/
@Service
@Transactional
public class ComplaintServiceImpl implements ComplaintService {

    @Autowired
    private ComplaintDao complaintDao;

    @Override
    public void save(Complaint complaint) {
        complaintDao.save(complaint);
    }

    @Override
    public void delete(Complaint complaint) {
        complaintDao.delete(complaint);
    }

    @Override
    public Complaint getById(Integer id) {
        return complaintDao.getOne(id);
    }

    @Override
    public List<Complaint> findAll() {
        return complaintDao.findAll();
    }

}
