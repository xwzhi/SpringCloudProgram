package com.hdo.mybatis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringRunner;
import sun.text.resources.ja.JavaTimeSupplementary_ja;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

/**
 * @ClassName Maitest
 * @Author XuWeiZhi
 * @Description
 * @Date 2018-09-12 11:23 星期三 SpringBootProgram
 * @VERSION 1.0.0
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class Maitest {

    @Autowired
    private JavaMailSenderImpl javaMailSender;

    @Test
    public void contextLoads(){
        //简单邮件发送
        SimpleMailMessage message=new SimpleMailMessage();
        //邮件设置
        //标题
        message.setSubject("今晚五点开会！");
        message.setText("来自诚骏科技深切问候！");

        //发送个哦书
        message.setTo("352141324@qq.com");
        //发送者
        message.setFrom("624244232@qq.com");
        javaMailSender.send(message);
    }

    @Test
    public void contextLoads2() throws MessagingException {

        //复杂邮件发送
        MimeMessage message=javaMailSender.createMimeMessage();
        MimeMessageHelper helper=new MimeMessageHelper(message,true);

        //邮件设置
        helper.setSubject("小姐姐一次烛光晚餐！");
        helper.setText("<a href='www.baidu.com' style='color:red'>高危预警！</a>",true);

        helper.setTo("158262751@qq.com");
        helper.setFrom("624244232@qq.com");
        helper.addAttachment("1.jpg",new File("C:\\Users\\Administrator\\Desktop\\tets\\HTML.png"));
        helper.addAttachment("2.jpg",new File("C:\\Users\\Administrator\\Desktop\\tets\\xmlDOM解析方式.png"));

        javaMailSender.send(message);
    }
}
