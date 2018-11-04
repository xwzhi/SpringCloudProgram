package com.springcloud.product.enums;

import lombok.Getter;

/**
 *@Author XuWeiZhi
 *@Description
 *@Date 2018/10/9 23:42
 **/
@Getter
public enum ResultEnum {

    PRODUCT_NOT_EXIST(1, "商品不存在"),
    PRODUCT_STOCK_ERROR(2, "库存有误");

    private Integer code;

    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
