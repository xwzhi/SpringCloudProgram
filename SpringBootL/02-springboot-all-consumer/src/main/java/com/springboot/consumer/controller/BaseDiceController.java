package com.springboot.consumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: XWZ
 * @Date: Create In 2018/8/12 21:50: 星期日 web
 * @Description:
 */
@Controller
@RequestMapping("/baseDist")
public class BaseDiceController {

    @Reference(version = "1.0.0",timeout = 10000)
    private BaseDiceService baseDiceService;


    @RequestMapping("/getList")
    public String getAllBaseDict(Model model) {
        model.addAttribute("baseDictList", baseDiceService.getAllBaseDice());
        return "BaseDictList" ;
    }

    @RequestMapping("/getList2")
    public String getAllBaseDict2(Model model, @RequestParam(defaultValue = "1")Integer page,@RequestParam(defaultValue = "10")Integer pageSize){
        int totalRows=baseDiceService.getBaseDictByTotal();
        PageModel<BaseDict> pages=new PageModel<>(page, pageSize, totalRows);
        Map<String,Object> map=new HashMap<>();
        map.put("startRow",pages.getStartRow());
        map.put("pageSize",pages.getPageSize());
        System.out.println(pages.getStartPage());
        System.out.println(pages.getEndPage());
        List<BaseDict> baseDict=baseDiceService.getBaseDictByPage(map);
        pages.setRows(baseDict);
        pages.setUrl("/baseDist/getList2");
        model.addAttribute("page", pages);
        return "BaseDictList2" ;
    }

    @RequestMapping("/delete")
    public String deleteBaseDist(Integer dictId,@RequestParam(defaultValue = "1")Integer currentPage){
        baseDiceService.deleteBaseDict(dictId);
        return "forward:/baseDist/getList2?=currentPage"+currentPage;
    }

    @RequestMapping("/toAdd")
    public String toAdd(Model model) {
        return "editBase";
    }

    @RequestMapping("/toUpdate")
    public String toUpdate(Integer dictId,Model model) {
        model.addAttribute("baseDict", baseDiceService.getBaseDictById(dictId));
        return "updateBase";
    }

    @RequestMapping("/addBase")
    public String addBase(BaseDict baseDict){
        baseDiceService.insertBaseDict(baseDict);
        return "redirect:/baseDist/getList2";
    }

    @RequestMapping("/updateBase")
    public String updateBase(BaseDict baseDict){
        baseDiceService.updateBaseDict(baseDict);
        return "redirect:/baseDist/getList2";
    }

}
