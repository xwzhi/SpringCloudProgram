package com.spring.product.common;

import lombok.Data;

/**
 *@Author XuWeiZhi
 *@Description
 *@Date 2018/10/9 23:53
 **/
@Data
public class DecreaseStockInput {

    private String productId;

    private Integer productQuantity;

    public DecreaseStockInput() {

    }

    public DecreaseStockInput(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}