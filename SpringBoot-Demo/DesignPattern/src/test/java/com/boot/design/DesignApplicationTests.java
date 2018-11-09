package com.boot.design;

import com.boot.design.simplefactory.BeanFactory;
import com.boot.design.simplefactory.HistoryFactory;
import com.boot.design.simplefactory.Library;
import com.boot.design.simplefactory.LibraryFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DesignApplicationTests {

    @Autowired
    private LibraryFactory libraryFactory;

    @Test
    public void contextLoads() {
    }

    @Test
    public void simpleFactoyTest() {
        //LibraryFactory libraryFactory=new LibraryFactory();
        Library library = libraryFactory.getLibaray("car");
        library.borrowBookType();

        //传递参数错误 不能创建对象
        Library xx = libraryFactory.getLibaray("xx");
        xx.borrowBookType();
    }

    //静态工厂 不需要创建实例获取对象
    @Test
    public void simpleFactory() {
        LibraryFactory.getCarTye().borrowBookType();
    }

    //工厂模式：这样做的好处就是
    // 新增功能是 只需要 实现Libray（扩展） 接口 和 实现 BeanFactory接口实现新增功能
    @Test
    public void factoryDeisgnPatter() {
        //1.获取BeanFactory
        BeanFactory beanFactory = new HistoryFactory();
        //2.获取Library对象
        Library library = beanFactory.produce();
        //3.借书
        library.borrowBookType();
    }



}
