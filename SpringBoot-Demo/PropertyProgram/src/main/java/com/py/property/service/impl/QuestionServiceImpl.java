package com.py.property.service.impl;


import com.py.property.entity.Question;
import com.py.property.repository.QuestionDao;
import com.py.property.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @ClassName QuestionServiceImpl
 * @Author XuWeiZhi
 * @Description
 * @Date 2018-11-02 17:11 星期五 property
 * @VERSION 1.0.0
 **/
@Service
@Transactional
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionDao questionDao;

    @Override
    public void save(Question question) {
        questionDao.save(question);
    }

    @Override
    public void delete(Question question) {
        questionDao.delete(question);
    }

    @Override
    public Question getById(Integer id) {
        return questionDao.getOne(id);
    }

    @Override
    public List<Question> findAll() {
        return questionDao.findAll();
    }
}
