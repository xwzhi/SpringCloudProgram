package com.hdo.mybatis.controller;

import com.hdo.mybatis.bean.Loginnum;
import com.hdo.mybatis.service.LoginnumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @ClassName LoginnumController
 * @Author XWZ
 * @Description
 * @Date 2018-09-05 17:59 星期三 SpringBootProgram
 * @VERSION 1.0.0
 **/
@Controller
@RequestMapping("/loginnum")
public class LoginnumController {

    @Autowired
    private LoginnumService loginnumService;

    @GetMapping("/get/{id}")
    public String getLoginnum(@PathVariable(value="id")Integer id, Model model){
        Loginnum loginnum=loginnumService.getLoginnum(id);
        model.addAttribute("msg",loginnum);
        return "index";
    }

    @RequestMapping("/add")
    @ResponseBody
    public int addLoginnum(Loginnum loginnum){
        System.out.println();
        return loginnumService.save(loginnum);
    }

    @RequestMapping("/getAll")
    @ResponseBody
    public List<Loginnum> getAll(){
        return  loginnumService.getAll();
    }

    @RequestMapping("/delete")
    @ResponseBody
    public String delete(Integer id){
        loginnumService.delete(id);
        return "success";
    }

    @PutMapping("/update")
    public String update(Loginnum loginnum, HttpServletRequest request, HttpServletResponse response, Model model) throws Exception{
        System.out.println(request.getServletContext().getContextPath());
        loginnumService.update(loginnum);
        model.addAttribute("msg",loginnum);
        return "login";
    }
}
