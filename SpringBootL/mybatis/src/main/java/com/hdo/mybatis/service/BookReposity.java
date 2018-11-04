package com.hdo.mybatis.service;

import com.hdo.mybatis.bean.Book;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

/**
 * @ClassName BookReposity
 * @Author XuWeiZhi
 * @Description
 * @Date 2018-09-12 09:59 星期三 SpringBootProgram
 * @VERSION 1.0.0
 **/
public interface BookReposity/* extends ElasticsearchRepository<Book,Integer>*/ {

    public List<Book> findByBookNameLike(String bookName);
}
