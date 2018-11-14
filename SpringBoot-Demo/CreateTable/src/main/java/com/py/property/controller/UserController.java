package com.py.property.controller;

import com.py.property.entity.User;
import com.py.property.enums.StatusEnum;
import com.py.property.service.UserService;
import com.py.property.until.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * @ClassName UserController
 * @Author XuWeiZhi
 * @Description
 * @Date 2018-10-29 14:45 星期一 MyProgram
 * @VERSION 1.0.0
 **/
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("saveUser/{id}")
    public String saveUser(@RequestBody User user, @PathVariable(value = "id") String id) {
        if (!StringUtils.isNotEmpty(user.getPassword())) {
            return StatusEnum.ERROR.getStatus();
        }
        String md5 = StringUtils.StringToMd5(user.getPassword());
        user.setPassword(md5);
        user.setCreateTime(new Date());
        userService.save(user);
        return StatusEnum.SUCCESS.getStatus();
    }

    @GetMapping("get")
    public void test(String name) {
        System.out.println(name);
    }

    @PostMapping("login")
    public String login(@RequestBody User user) {
        System.out.println(user);
        User login = userService.login(user);
         String password = StringUtils.StringToMd5(user.getPassword());
        if (password.equals(login.getPassword()))
            return StatusEnum.SUCCESS.getStatus();
        return StatusEnum.ERROR.getStatus();
    }

}
