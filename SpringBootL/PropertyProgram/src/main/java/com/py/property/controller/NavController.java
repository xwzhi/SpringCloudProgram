package com.py.property.controller;

import com.py.property.entity.ManageItem;
import com.py.property.entity.Nav;
import com.py.property.entity.NavItem;
import com.py.property.entity.WorkStatus;
import com.py.property.enums.ItemEnum;
import com.py.property.service.NavService;
import com.py.property.service.WorkStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @ClassName NavController
 * @Author XuWeiZhi
 * @Description
 * @Date 2018-11-01 15:04 星期四 property
 * @VERSION 1.0.0
 **/
@RestController
@RequestMapping("/nav")
public class NavController {

    @Autowired
    private NavService navService;

    @Autowired
    private WorkStatusService workStatusService;

    @GetMapping("/list")
    public List<Nav> getAllNav() {
        return navService.findAll();
    }


    @GetMapping("/save")
    public void addNav() {
        /*默认最新状态被激活*/
        Nav nav1 = new Nav("最新动态", "/newsHome", true);
        Set<NavItem> navItems = new HashSet<>();
        navItems.add(new NavItem("工作态度", "./workDynamics"));
        navItems.add(new NavItem("工作报告", "./workReport"));
        navItems.add(new NavItem("和美一街", "./workDynamics"));
        navItems.add(new NavItem("胜利广场", "./workReport"));
        nav1.setNavItems(navItems);
        Nav nav2 = new Nav("管理机构", "/manageAgency", false);
        Set<NavItem> navItems2 = new HashSet<>();
        navItems2.add(new NavItem("工作态度", "./workDynamics"));
        navItems2.add(new NavItem("工作报告", "./workReport"));
        nav2.setNavItems(navItems2);
        navService.save(nav1);
        navService.save(nav2);
    }


    @GetMapping("/save2")
    public void addNav2() {
        /*默认最新状态被激活*/
        Nav nav1 = new Nav("公示公告", "/advice", true);
        Set<NavItem> navItems = new HashSet<>();
        navItems.add(new NavItem("公示公告", "/0"));
        nav1.setNavItems(navItems);

        Nav nav2 = new Nav("政策法规", "/policy", false);
        Set<NavItem> navItems2 = new HashSet<>();
        navItems2.add(new NavItem("政策法规", "/0"));
        nav2.setNavItems(navItems2);

        Nav nav3 = new Nav("资金监管", "/capital", false);
        Set<NavItem> navItems3 = new HashSet<>();
        navItems3.add(new NavItem("资金监管", "/0"));
        nav3.setNavItems(navItems3);

        Nav nav4 = new Nav("典型案例", "/cases", false);
        Set<NavItem> navItems4 = new HashSet<>();
        navItems4.add(new NavItem("典型案例", "/0"));
        nav4.setNavItems(navItems4);

        Nav nav5 = new Nav("办事指南", "/affairs", false);
        Set<NavItem> navItems5 = new HashSet<>();
        navItems5.add(new NavItem("办事指南", "/0"));
        nav5.setNavItems(navItems5);

        Nav nav7 = new Nav("资料下载", "/download", false);
        Set<NavItem> navItems7 = new HashSet<>();
        navItems7.add(new NavItem("资料下载", "/0"));
        nav7.setNavItems(navItems7);

        Nav nav8 = new Nav("名录", "/directories", false);
        Set<NavItem> navItems8 = new HashSet<>();
        navItems8.add(new NavItem("施工单位名录", "/0"));
        navItems8.add(new NavItem("审价单位名录", "/1"));
        nav8.setNavItems(navItems8);


        Nav nav9 = new Nav("投诉", "/complaint", false);
        Set<NavItem> navItems9 = new HashSet<>();
        navItems9.add(new NavItem("投诉", "/0"));
        nav9.setNavItems(navItems9);

        Nav nav10 = new Nav("问题解答", "/question", false);
        Set<NavItem> navItems10 = new HashSet<>();
        navItems10.add(new NavItem("问题解答", "/0"));
        nav10.setNavItems(navItems10);

        Nav nav11 = new Nav("日志管理", "/log", false);
        Set<NavItem> navItems11 = new HashSet<>();
        navItems11.add(new NavItem("日志管理", "/0"));
        nav11.setNavItems(navItems11);

        navService.save(nav1);
        navService.save(nav2);
        navService.save(nav3);
        navService.save(nav4);
        navService.save(nav5);
        navService.save(nav7);
        navService.save(nav8);
        navService.save(nav9);
        navService.save(nav10);
        navService.save(nav11);

        Set<ManageItem> items = new HashSet<>();
        items.add(new ManageItem(ItemEnum.DETAILS.getCODE(), ItemEnum.DETAILS.getOPERATION()));
        items.add(new ManageItem(ItemEnum.COMMIT.getCODE(), ItemEnum.COMMIT.getOPERATION()));
        items.add(new ManageItem(ItemEnum.DELETE.getCODE(), ItemEnum.DELETE.getOPERATION()));
        items.add(new ManageItem(ItemEnum.EXAMINEFAIL.getCODE(), ItemEnum.EXAMINEFAIL.getOPERATION()));
        items.add(new ManageItem(ItemEnum.ENCLOSURE.getCODE(), ItemEnum.ENCLOSURE.getOPERATION()));
        Set<ManageItem> items1 = new HashSet<>();
        items1.add(new ManageItem(ItemEnum.DETAILS.getCODE(), ItemEnum.DETAILS.getOPERATION()));
        items1.add(new ManageItem(ItemEnum.COMMIT.getCODE(), ItemEnum.COMMIT.getOPERATION()));
        items1.add(new ManageItem(ItemEnum.DELETE.getCODE(), ItemEnum.DELETE.getOPERATION()));
        items1.add(new ManageItem(ItemEnum.EXAMINEFAIL.getCODE(), ItemEnum.EXAMINEFAIL.getOPERATION()));
        items1.add(new ManageItem(ItemEnum.ENCLOSURE.getCODE(), ItemEnum.ENCLOSURE.getOPERATION()));
        Set<ManageItem> items2 = new HashSet<>();
        items2.add(new ManageItem(ItemEnum.DETAILS.getCODE(), ItemEnum.DETAILS.getOPERATION()));
        items2.add(new ManageItem(ItemEnum.COMMIT.getCODE(), ItemEnum.COMMIT.getOPERATION()));
        items2.add(new ManageItem(ItemEnum.DELETE.getCODE(), ItemEnum.DELETE.getOPERATION()));
        items2.add(new ManageItem(ItemEnum.EXAMINEFAIL.getCODE(), ItemEnum.EXAMINEFAIL.getOPERATION()));
        items2.add(new ManageItem(ItemEnum.ENCLOSURE.getCODE(), ItemEnum.ENCLOSURE.getOPERATION()));
        Set<ManageItem> items3 = new HashSet<>();
        items3.add(new ManageItem(ItemEnum.DETAILS.getCODE(), ItemEnum.DETAILS.getOPERATION()));
        items3.add(new ManageItem(ItemEnum.COMMIT.getCODE(), ItemEnum.COMMIT.getOPERATION()));
        items3.add(new ManageItem(ItemEnum.DELETE.getCODE(), ItemEnum.DELETE.getOPERATION()));
        items3.add(new ManageItem(ItemEnum.EXAMINEFAIL.getCODE(), ItemEnum.EXAMINEFAIL.getOPERATION()));
        items3.add(new ManageItem(ItemEnum.ENCLOSURE.getCODE(), ItemEnum.ENCLOSURE.getOPERATION()));
        Set<ManageItem> items4 = new HashSet<>();
        items4.add(new ManageItem(ItemEnum.DETAILS.getCODE(), ItemEnum.DETAILS.getOPERATION()));
        items4.add(new ManageItem(ItemEnum.COMMIT.getCODE(), ItemEnum.COMMIT.getOPERATION()));
        items4.add(new ManageItem(ItemEnum.DELETE.getCODE(), ItemEnum.DELETE.getOPERATION()));
        items4.add(new ManageItem(ItemEnum.EXAMINEFAIL.getCODE(), ItemEnum.EXAMINEFAIL.getOPERATION()));
        items4.add(new ManageItem(ItemEnum.ENCLOSURE.getCODE(), ItemEnum.ENCLOSURE.getOPERATION()));
        Set<ManageItem> items5 = new HashSet<>();
        items.add(new ManageItem(ItemEnum.DETAILS.getCODE(), ItemEnum.DETAILS.getOPERATION()));
        items5.add(new ManageItem(ItemEnum.COMMIT.getCODE(), ItemEnum.COMMIT.getOPERATION()));
        items5.add(new ManageItem(ItemEnum.DELETE.getCODE(), ItemEnum.DELETE.getOPERATION()));
        items5.add(new ManageItem(ItemEnum.EXAMINEFAIL.getCODE(), ItemEnum.EXAMINEFAIL.getOPERATION()));
        items5.add(new ManageItem(ItemEnum.ENCLOSURE.getCODE(), ItemEnum.ENCLOSURE.getOPERATION()));
        WorkStatus status = new WorkStatus("你好", ItemEnum.DELETE.getSTATUS(), new Date(), items);
        WorkStatus status1 = new WorkStatus("Angular", ItemEnum.DELETE.getSTATUS(), new Date(), items1);
        WorkStatus status2 = new WorkStatus("Nice", ItemEnum.DELETE.getSTATUS(), new Date(), items2);
        WorkStatus status3 = new WorkStatus("Too", ItemEnum.DELETE.getSTATUS(), new Date(), items3);
        WorkStatus status4 = new WorkStatus("Me", ItemEnum.DELETE.getSTATUS(), new Date(), items4);
        WorkStatus status5 = new WorkStatus("You", ItemEnum.DELETE.getSTATUS(), new Date(), items5);
        workStatusService.save(status);
        workStatusService.save(status1);
        workStatusService.save(status2);
        workStatusService.save(status3);
        workStatusService.save(status4);
        workStatusService.save(status5);


    }

    @GetMapping("/add")
    public void add() {
        Set<ManageItem> items = new HashSet<>();
        items.add(new ManageItem(ItemEnum.DETAILS.getCODE(), ItemEnum.DETAILS.getOPERATION()));
        items.add(new ManageItem(ItemEnum.COMMIT.getCODE(), ItemEnum.COMMIT.getOPERATION()));
        items.add(new ManageItem(ItemEnum.DELETE.getCODE(), ItemEnum.DELETE.getOPERATION()));
        items.add(new ManageItem(ItemEnum.EXAMINEFAIL.getCODE(), ItemEnum.EXAMINEFAIL.getOPERATION()));
        items.add(new ManageItem(ItemEnum.ENCLOSURE.getCODE(), ItemEnum.ENCLOSURE.getOPERATION()));
        Set<ManageItem> items1 = new HashSet<>();
        items1.add(new ManageItem(ItemEnum.DETAILS.getCODE(), ItemEnum.DETAILS.getOPERATION()));
        items1.add(new ManageItem(ItemEnum.COMMIT.getCODE(), ItemEnum.COMMIT.getOPERATION()));
        items1.add(new ManageItem(ItemEnum.DELETE.getCODE(), ItemEnum.DELETE.getOPERATION()));
        items1.add(new ManageItem(ItemEnum.EXAMINEFAIL.getCODE(), ItemEnum.EXAMINEFAIL.getOPERATION()));
        items1.add(new ManageItem(ItemEnum.ENCLOSURE.getCODE(), ItemEnum.ENCLOSURE.getOPERATION()));
        Set<ManageItem> items2 = new HashSet<>();
        items2.add(new ManageItem(ItemEnum.DETAILS.getCODE(), ItemEnum.DETAILS.getOPERATION()));
        items2.add(new ManageItem(ItemEnum.COMMIT.getCODE(), ItemEnum.COMMIT.getOPERATION()));
        items2.add(new ManageItem(ItemEnum.DELETE.getCODE(), ItemEnum.DELETE.getOPERATION()));
        items2.add(new ManageItem(ItemEnum.EXAMINEFAIL.getCODE(), ItemEnum.EXAMINEFAIL.getOPERATION()));
        items2.add(new ManageItem(ItemEnum.ENCLOSURE.getCODE(), ItemEnum.ENCLOSURE.getOPERATION()));
        Set<ManageItem> items3 = new HashSet<>();
        items3.add(new ManageItem(ItemEnum.DETAILS.getCODE(), ItemEnum.DETAILS.getOPERATION()));
        items3.add(new ManageItem(ItemEnum.COMMIT.getCODE(), ItemEnum.COMMIT.getOPERATION()));
        items3.add(new ManageItem(ItemEnum.DELETE.getCODE(), ItemEnum.DELETE.getOPERATION()));
        items3.add(new ManageItem(ItemEnum.EXAMINEFAIL.getCODE(), ItemEnum.EXAMINEFAIL.getOPERATION()));
        items3.add(new ManageItem(ItemEnum.ENCLOSURE.getCODE(), ItemEnum.ENCLOSURE.getOPERATION()));
        Set<ManageItem> items4 = new HashSet<>();
        items4.add(new ManageItem(ItemEnum.DETAILS.getCODE(), ItemEnum.DETAILS.getOPERATION()));
        items4.add(new ManageItem(ItemEnum.COMMIT.getCODE(), ItemEnum.COMMIT.getOPERATION()));
        items4.add(new ManageItem(ItemEnum.DELETE.getCODE(), ItemEnum.DELETE.getOPERATION()));
        items4.add(new ManageItem(ItemEnum.EXAMINEFAIL.getCODE(), ItemEnum.EXAMINEFAIL.getOPERATION()));
        items4.add(new ManageItem(ItemEnum.ENCLOSURE.getCODE(), ItemEnum.ENCLOSURE.getOPERATION()));
        Set<ManageItem> items5 = new HashSet<>();
        items.add(new ManageItem(ItemEnum.DETAILS.getCODE(), ItemEnum.DETAILS.getOPERATION()));
        items5.add(new ManageItem(ItemEnum.COMMIT.getCODE(), ItemEnum.COMMIT.getOPERATION()));
        items5.add(new ManageItem(ItemEnum.DELETE.getCODE(), ItemEnum.DELETE.getOPERATION()));
        items5.add(new ManageItem(ItemEnum.EXAMINEFAIL.getCODE(), ItemEnum.EXAMINEFAIL.getOPERATION()));
        items5.add(new ManageItem(ItemEnum.ENCLOSURE.getCODE(), ItemEnum.ENCLOSURE.getOPERATION()));
        WorkStatus status = new WorkStatus("你好", ItemEnum.DELETE.getSTATUS(), new Date(), items);
        WorkStatus status1 = new WorkStatus("Angular", ItemEnum.DELETE.getSTATUS(), new Date(), items1);
        WorkStatus status2 = new WorkStatus("Nice", ItemEnum.DELETE.getSTATUS(), new Date(), items2);
        WorkStatus status3 = new WorkStatus("Too", ItemEnum.DELETE.getSTATUS(), new Date(), items3);
        WorkStatus status4 = new WorkStatus("Me", ItemEnum.DELETE.getSTATUS(), new Date(), items4);
        WorkStatus status5 = new WorkStatus("You", ItemEnum.DELETE.getSTATUS(), new Date(), items5);
        workStatusService.save(status);
        workStatusService.save(status1);
        workStatusService.save(status2);
        workStatusService.save(status3);
        workStatusService.save(status4);
        workStatusService.save(status5);
    }
}

