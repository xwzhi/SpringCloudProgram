package com.hdo.mybatis.bean;

/**
 * @ClassName LoverPeople
 * @Author XuWeiZhi
 * @Description
 * @Date 2018-10-29 11:18 星期一 MyProgram
 * @VERSION 1.0.0
 **/
public class LoverPeople extends Love<LoverPeople, String> {

    private String name;
    private String index;

    public static void main(String[] args) throws Exception {
        Love a = new LoverPeople();
        Object xx = (LoverPeople)a.getData("xx");
        System.out.println(xx);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    @Override
    public String toString() {
        return "LoverPeople{" +
                "name='" + name + '\'' +
                ", index='" + index + '\'' +
                '}';
    }
}
