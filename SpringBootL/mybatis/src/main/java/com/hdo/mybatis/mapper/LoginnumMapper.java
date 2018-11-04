package com.hdo.mybatis.mapper;

import com.hdo.mybatis.bean.Loginnum;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @ClassName LoginnumMapper
 * @Author XWZ
 * @Description
 * @Date 2018-09-05 17:44 星期三 SpringBootProgram
 * @VERSION 1.0.0
 **/
@Mapper
public interface LoginnumMapper {

    @Insert("insert into Loginnum(department) values(#{department})")
    @Options(keyProperty = "id",useGeneratedKeys = true,keyColumn = "id")
    public int save(Loginnum loginnum);

    @Delete("delete from loginnum where id=#{id}")
    public void delete(Integer id);

    @Update("update loginnum set department=#{department},ip_address=#{ipAddress},name=#{name},number=#{number},total_login_num=#{totalLoginNum} where id=#{id}")
    public void update(Loginnum loginnum);

    @Select("select * from loginnum where id=#{id}")
    public Loginnum getLoginnum(Integer id);

    @Select("select * from loginnum")
    public List<Loginnum> getAll();
}
