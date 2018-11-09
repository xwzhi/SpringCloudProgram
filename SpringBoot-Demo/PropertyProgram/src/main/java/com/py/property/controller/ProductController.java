package com.py.property.controller;

import com.py.property.entity.Product;
import com.py.property.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

/**
 * @ClassName ProductController
 * @Author XuWeiZhi
 * @Description
 * @Date 2018-10-26 13:15 星期五 MyProgram
 * @VERSION 1.0.0
 **/
@RestController
@RequestMapping("api")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    private static int i = 0;

    @GetMapping("index")
    public String getIndex() {
        return "cc";
    }

    @GetMapping("products")
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @GetMapping("addProduct")
    public void addProduct() {
        for (; i < 10; i++) {
            BigDecimal bigDecimal1 = new BigDecimal((int) (Math.random() * 100));
            BigDecimal bigDecimal = new BigDecimal((int) (Math.random() * 5));
            Product product = new Product();
            product.setPrice(bigDecimal1);
            product.setRating(bigDecimal);
            product.setTitle("商品" + i);
            product.setDescrs("我很开心");
            productRepository.save(product);
        }

    }

}
