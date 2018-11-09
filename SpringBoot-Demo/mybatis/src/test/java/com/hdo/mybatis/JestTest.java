package com.hdo.mybatis;

import com.hdo.mybatis.bean.Book;
import com.hdo.mybatis.service.BookReposity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JestTest {

    //@Autowired
    //private BookReposity bookReposity;
    //
    //@Test
    //public void test(){
    //    Book book=new Book();
    //    bookReposity.index(book);
    //}

   /* @Autowired
    private JestClient jestClient;

    @Test
    public void test() throws IOException {
        //给ES文档中添加一个索引
        Faker faker=new Faker();
        faker.setId(1);
        faker.setName("Faker");
        faker.setWorld("我是大魔王");
        faker.setAge("12");
        //創建索引 把faker放入文档中 创建hdo 索引 类型事person
        //http://118.24.44.169:9200/hdo/person/1
        Index index = new Index.Builder(faker).index("product").type("person").build();
        jestClient.execute(index);
    }

    @Test
    public void test1() throws IOException {
        String json="{query:{match:{name:faker}}}";
        Search search = new Search.Builder(json).addIndex("product").addType("person").build();
        SearchResult result = jestClient.execute(search);
        System.out.println(result.getJsonString());
    }*/


}
