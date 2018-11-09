package com.springcloud.product.service.impl;

import com.springcloud.product.dataobject.ProductCategory;
import com.springcloud.product.repository.ProductCategoryRepository;
import com.springcloud.product.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *@Author XuWeiZhi
 *@Description
 *@Date 2018/10/9 23:43
 **/
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @Override
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList) {
        return productCategoryRepository.findByCategoryTypeIn(categoryTypeList);
    }
}
