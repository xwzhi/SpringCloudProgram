package com.demo.project.serviceimpl;

import com.alibaba.dubbo.config.annotation.Service;
import com.demo.project.mapper.BaseDictMapper;
import com.demo.project.model.BaseDict;
import com.demo.project.model.BaseDictExample;
import com.demo.project.pojo.PageModel;
import com.demo.project.service.BaseDiceService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @Author: XWZ
 * @Date: Create In 2018/8/12 21:36: 星期日 web
 * @Description:
 */
@Transactional
@Component
@Service(version = "1.0.0",timeout = 100000)
public class BaseDictImpl implements BaseDiceService {

   /* 对应的Mapper接口类 添加@Mapper
    * 或者在SpringBootApplication添加@MapperScan(basePackages = "com.demo.project.mapper")
    * 把接口映射文件交给Spring管理（控制反转--依赖注入）不懂得自行百度
    */
    @Autowired
    private BaseDictMapper baseDictMapper;

    @Autowired
    private RedisTemplate<Object,Object> redis;
    @Override
    public List<BaseDict> getAllBaseDice() {
        return baseDictMapper.selectByExample(new BaseDictExample());
    }

    @Override
    public List<BaseDict> getBaseDictByPage(Map<String, Object> paramMap) {
//       Mybatis 逆向工程只能生成表查询 想获取分页信息 自己写sql或者
//       官方提供了一个PageHelper插件
        /*PageHelper.startPage((Integer)paramMap.get("startRows"), (Integer)paramMap.get("totao"));
        List<BaseDict> baseDicts=baseDictMapper.selectByExample(new BaseDictExample());
        PageInfo<BaseDict>  pageInfo=new PageInfo<>(baseDicts);
        PageModel<BaseDict> pageModel=new PageModel();
        pageModel.setTotal((int)pageInfo.getTotal());
        pageModel.setRows(pageInfo.getList());*/
        return baseDictMapper.selectBaseDictByPage(paramMap);
    }



    @Override
    public int getBaseDictByTotal() {
        RedisSerializer serializer=new StringRedisSerializer();
        redis.setKeySerializer(serializer);
        Integer total=(Integer)redis.opsForValue().get("total");
        if(total==null){
            synchronized (this){
                total=(Integer)redis.opsForValue().get("total");
                if(total==null){
                    total=baseDictMapper.selectBaseDictByTotal();
                }
            }
        }
        return total;
    }

    @Override
    public void deleteBaseDict(Integer dictId) {
        if (dictId!=null){
            baseDictMapper.deleteByPrimaryKey(dictId);
            redis.opsForValue().set("total", baseDictMapper.selectBaseDictByTotal());
        }

    }

    @Override
    public void updateBaseDict(BaseDict baseDict) {
       baseDictMapper.updateByPrimaryKey(baseDict);
    }

    @Override
    public void insertBaseDict(BaseDict baseDict) {
        baseDictMapper.insertSelective(baseDict);
        redis.opsForValue().set("toatl",baseDictMapper.selectBaseDictByTotal()+1);
    }

    @Override
    public BaseDict getBaseDictById(Integer dicId) {
        return baseDictMapper.selectByPrimaryKey(dicId);
    }

    @Override
    public PageModel<BaseDict> getPageModel(Integer pageSize, Integer page) {
        if(page<=0){
            page=1;
        }
        PageModel<BaseDict> pageModel=new PageModel<>(page, pageSize, baseDictMapper.selectBaseDictByTotal());
        if (page>pageModel.getPageNum()){
            page=pageModel.getPageNum();
        }
        PageHelper.startPage(page, pageSize);
        List<BaseDict> list=baseDictMapper.selectByExample(new BaseDictExample());
        return null;
    }
}
