package com.demo.project.service;

import com.demo.project.model.BaseDict;
import com.demo.project.pojo.PageModel;

import java.util.List;
import java.util.Map;

/**
 * @Author: XWZ
 * @Date: Create In 2018/8/12 21:25: 星期日 web
 * @Description:
 */
public interface BaseDiceService {

    public List<BaseDict> getAllBaseDice();

    /**
     * 分页查询
     * @param 分页查询条件 pages 和size
     * @return 返回分页数据
     */
    public List<BaseDict> getBaseDictByPage(Map<String,Object> paramMap);

    /**
     * 分页查询总页数
     * @return 返回总记录数
     */
    int getBaseDictByTotal();

    public void deleteBaseDict(Integer dictId);

    public void updateBaseDict(BaseDict baseDict);

    public void insertBaseDict(BaseDict baseDict);

    public BaseDict getBaseDictById(Integer dicId);

    public PageModel<BaseDict> getPageModel(Integer pageSize,Integer page);

}
