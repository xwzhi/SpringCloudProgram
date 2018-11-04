package com.py.property.service.impl;

import com.py.property.entity.Policy;
import com.py.property.repository.PolicyDao;
import com.py.property.service.PolicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @ClassName PolicyServiceImpl
 * @Author XuWeiZhi
 * @Description
 * @Date 2018-11-02 17:11 星期五 property
 * @VERSION 1.0.0
 **/
@Service
@Transactional
public class PolicyServiceImpl implements PolicyService {

    @Autowired
    private PolicyDao policyDao;

    @Override
    public void save(Policy casesPolicy) {
        policyDao.save(casesPolicy);
    }

    @Override
    public void delete(Policy casesPolicy) {
        policyDao.delete(casesPolicy);
    }

    @Override
    public Policy getById(Integer id) {
        return policyDao.getOne(id);
    }

    @Override
    public List<Policy> findAll() {
        return policyDao.findAll();
    }
}
