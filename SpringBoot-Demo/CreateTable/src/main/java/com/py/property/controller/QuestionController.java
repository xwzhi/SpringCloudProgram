package com.py.property.controller;

import com.py.property.entity.Question;
import com.py.property.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName QuestionController
 * @Author XuWeiZhi
 * @Description
 * @Date 2018-11-02 17:32 星期五 property
 * @VERSION 1.0.0
 **/
@RestController
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @GetMapping("/list")
    public List<Question> getList() {
        return questionService.findAll();
    }

}
