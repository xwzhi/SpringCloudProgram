package com.springcloud.product.service;

import com.spring.product.common.DecreaseStockInput;
import com.spring.product.common.ProductInfoOutput;
import com.springcloud.product.dataobject.ProductInfo;

import java.util.List;

/**
 *@Author XuWeiZhi
 *@Description
 *@Date 2018/10/9 23:41
 **/
public interface ProductService {

    /**
     * 查询所有在架商品列表
     */
    List<ProductInfo> findUpAll();

    /**
     * 查询商品列表
     * @param productIdList
     * @return
     */
    List<ProductInfoOutput> findList(List<String> productIdList);

    /**
     * 扣库存
     * @param decreaseStockInputList
     */
    void decreaseStock(List<DecreaseStockInput> decreaseStockInputList);
}
