package com.hdo.mybatis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName AsyncService
 * @Author XuWeiZhi
 * @Description
 * @Date 2018-09-12 10:10 星期三 SpringBootProgram
 * @VERSION 1.0.0
 **/
@Service
public class AsyncService {


    public void hello(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("我被搞了！！");
    }
}
