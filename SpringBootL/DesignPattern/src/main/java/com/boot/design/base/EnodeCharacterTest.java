package com.boot.design.base;

import org.junit.jupiter.api.Test;
import org.springframework.web.servlet.tags.UrlTag;

import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.Arrays;

/**
 * @ClassName EnodeCharacterTest
 * @Author XuWeiZhi
 * @Description
 * @Date 2018-09-26 15:30 星期三 My1Program
 * @VERSION 1.0.0
 **/
public class EnodeCharacterTest {

    @Test
    public void test() throws UnsupportedEncodingException {
        byte[] bytes = {1, 2, 3, 4, 5, 6};
        //通过指定的解码方式构造一个新的函数
        byte[] bytes1 = new String(bytes, "UTF-8").getBytes();
        System.out.println(Arrays.asList(bytes));
    }

    @Test
    public void test1() {
     int[] i = new int[10];
     System.out.println(i[2]);
    }
}
