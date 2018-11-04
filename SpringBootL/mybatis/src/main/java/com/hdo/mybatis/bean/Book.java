package com.hdo.mybatis.bean;

import org.springframework.data.elasticsearch.annotations.Document;

/**
 * @ClassName Book
 * @Author XWZ
 * @Description
 * @Date 2018-09-10 23:02 星期一 SpringBootProgram
 * @VERSION 1.0.0
 **/
//@Document(indexName = "product",type = "book")
public class Book {

    private String author;

    private String username;

    private String background;

    public Book() {
    }

    public Book(String author, String username, String background) {
        this.author = author;
        this.username = username;
        this.background = background;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    @Override
    public String toString() {
        return "Book{" +
                "author='" + author + '\'' +
                ", username='" + username + '\'' +
                ", background='" + background + '\'' +
                '}';
    }
}
