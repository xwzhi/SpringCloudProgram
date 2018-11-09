package com.hdo.mybatis.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @ClassName ScheduledService
 * @Author XuWeiZhi
 * @Description 定时任务
 * @Date 2018-09-12 10:47 星期三 SpringBootProgram
 * @VERSION 1.0.0
 **/
@Service
public class ScheduledService {

    /**
     * second(秒),minute,hour, day of month,month,day of week
     *  * * * * * *   六个字符表示六个时间节点
     *  1-6 星期一到六 0 7表示周日
     *  0 0/5 14,18 * * ？  每天14，18点 每隔五分钟输出一信息
     *  0 15 10 ？ * 1-6  每个月星期1到6 10 15 0执行一次
     *  0 0 2 ？ * 6L 每个月最后一个星期六 2 0 0执行一次
     *  0 0 2 LW * ? 每个月最后一个工作日 执行一次
     *  0 0 2-4 ？ * 1#1 每个月的第一个星期1执行一次 隔一个小时执行一次
     **/
    @Scheduled(cron = "0 * * * * ?")
    public void tets1(){
        System.out.println("第一次执行"+new Date());
    }

   /* @Scheduled(cron = "0-5 * * * * ?")
    public void tets2(){
        System.out.println("第2次执行"+new Date());
    }

    @Scheduled(cron = "0,5 * * * * ?")
    public void tets3(){
        System.out.println("第3次执行"+new Date());
    }

    @Scheduled(cron = "0,5 0 * * * ?")
    public void tets4(){
        System.out.println("第4次执行"+new Date());
    }*/


}
