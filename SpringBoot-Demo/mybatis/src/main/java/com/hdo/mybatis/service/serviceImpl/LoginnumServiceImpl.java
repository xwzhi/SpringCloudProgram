package com.hdo.mybatis.service.serviceImpl;

import com.hdo.mybatis.bean.Loginnum;
import com.hdo.mybatis.bean.Warehouse;
import com.hdo.mybatis.mapper.LoginnumMapper;
import com.hdo.mybatis.mapper.WarehouseMapper;
import com.hdo.mybatis.service.LoginnumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName LoginnumServiceImpl
 * @Author XWZ
 * @Description
 * @Date 2018-09-05 17:57 星期三 SpringBootProgram
 * @VERSION 1.0.0
 **/
@Service
public class LoginnumServiceImpl implements LoginnumService {

    @Autowired
    private LoginnumMapper mapper;

    @Autowired
    private WarehouseMapper warehouseMapper;

    //操作字符串 K-V都是String
   /* @Autowired
    private StringRedisTemplate stringRedisTemplate;

    //K-V对象
    @Autowired
    private RedisTemplate redisTemplate;*/

    /**
     *Redis常见的五大数据类型
     * String(字符串),List(序列),Set(集合),Hash(散列),ZSet(有序集合)
     * redisTemplate.opsForValue(字符串);
     * redisTemplate.opsForList(序列);
     **/
   /* public void Test1(){
        //向Redis中保存数字
        redisTemplate.opsForValue().set("mss","sss");
        //redisTemplate.opsForValue().append("msg","你是一个大傻子");
        //System.out.println(redisTemplate.opsForValue().get("msg"));
        System.out.println("xxxxx");
    }*/

    @Override
    public int save(Loginnum loginnum) {
            return mapper.save(loginnum);
    }

    /**
     *指定需要删除的件
     *beforeInvocation = false 默认再方法运行之后执行
     *
     **/
    @CacheEvict(value = "emps",/*key = "#id",*/allEntries = true,beforeInvocation = false)
    @Override
    public void delete(Integer id) {
            mapper.delete(id);
    }

    /**
     * 即调用方法又更新缓存数据
     * 修改了数据库中的某个数据，同时更新缓存
     *  1. 先调用目标方法
     *  2. 将目标方法的结果缓存起来
     *  测试步骤
     *  1.查询1号员工,查到的结果放在缓存中
     *   key=3 value=loginnum3
     *  2.以后查询还是之前的结果
     *  3.更新员工，同时更新缓存
     *    将方法的返回值      放入缓存
     *    key:传入的loginnum对象 值返回的loginnum对象
     *  4.查询1号员工
     *    应该是更新后的员工
     *    key=" #loginnum.id":使用传入参数的id 和 1对应
     *    key=" #result.id:返回值得id
     *
     **/
    @CachePut(cacheNames = "emps",key = "#result.id")
    @Override
    public Loginnum update(Loginnum loginnum) {
           mapper.update(loginnum);
           return loginnum;
    }

    @Override
    public List<Loginnum> getAll() {
        return mapper.getAll();
    }

    /**
     *  cacheNames/value:指定缓存组件的名字;讲方法的返回结果放在哪个缓存中，是数组的方式，可以指定多个缓存
     *
     *   key:缓存数据使用的key,可以用它来指定。默认是使用方法参数的值，方法时的返回值
     *       编写spel #id:参数id的值， #ao #po #.roots.args[0]
     *
     *   keyGenerator:key的生成器，用他指定key的生成器的组件id 2二选一 与key
     *
     *
     *   cacaheManager:指定缓存管理器，
     *   condition:在缓存条件满足的情况执行缓存 "#id>0"
     *   unless:"#result == null"
     *   sync: 是否使用异步模式
     **/
    //@Cacheable(cacheNames = "emp",key = "#root.methodName+'{'+#id+'}'",condition = "#id>1 and #root.methodName eq 'getLoginnum'")
    //@Cacheable(cacheNames = "{emp}",keyGenerator = "myKeyGenerator")
    @Cacheable(cacheNames = "emps",key = "#id")
    @Override
    public Loginnum getLoginnum(Integer id) {
        //key以方法名加方法参数
        System.out.println("员工"+id);
        return mapper.getLoginnum(id);
    }

    @Cacheable(cacheNames = "warehouse",key = "#id")
    @Override
    public Warehouse getWarehouse(Integer id) {
        return warehouseMapper.getWarehouse(id);
    }
}
